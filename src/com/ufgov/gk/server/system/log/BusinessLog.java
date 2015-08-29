package com.ufgov.gk.server.system.log;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.system.Guid;
import com.ufgov.gk.common.system.model.AsLog;
import com.ufgov.gk.common.system.model.LangTrans;
import com.ufgov.gk.common.system.model.User;
import com.ufgov.gk.server.commonbiz.service.IBusinessLogService;
import com.ufgov.gk.server.system.service.ILangTransService;
import com.ufgov.gk.server.system.service.IUserService;
import com.ufgov.gk.server.system.util.RequestMetaUtil;

public class BusinessLog implements AfterReturningAdvice {

  private static final Logger logger = Logger.getLogger(BusinessLog.class);

  private IBusinessLogService businessLogService;

  private IUserService userService;

  private ILangTransService langTransService;

  public IUserService getUserService() {
    return userService;
  }

  public void setUserService(IUserService userService) {
    this.userService = userService;
  }

  public ILangTransService getLangTransService() {
    return langTransService;
  }

  public void setLangTransService(ILangTransService langTransService) {
    this.langTransService = langTransService;
  }

  public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

    if (logger.isDebugEnabled()) {
      logger.debug("BusinessLog - 开始");
    }
    Object businessObj = null;
    if (args != null && args.length > 0) {
      for (int i = 0; i < args.length; i++) {
        if (args[i] instanceof BaseBill) {
          businessObj = args[i];
          break;
        }
      }
    }
    try {
      saveLog(businessObj);
    } catch (Exception ex) {
      logger.error("写业务日志出现异常", ex);
    }

    if (logger.isDebugEnabled()) {
      logger.debug("BusinessLog - 结束");
    }

  }

  private void saveLog(Object businessObj) {

    AsLog log = new AsLog();
    log.setGuid(Guid.genID());
    log.setUserIP(RequestMetaUtil.getClientIP());
    log.setUserId(RequestMetaUtil.getSvUserID());
    log.setUserName(getUserName(log.getUserId()));
    log.setCompoId(RequestMetaUtil.getCompoId());
    log.setCompoName(getLangTransName(log.getCompoId()));
    log.setFuncId(RequestMetaUtil.getFuncId());
    log.setOperDesc(getLangTransName(log.getFuncId()));
    log.setIfSuc("Y");
    log.setOperTime(getSystemTime());

    String str = JSONObject.fromObject(businessObj).toString();
    if (str != null && str.getBytes().length > 4000) {
      byte[] arr = str.getBytes();
      str = new String(arr, 0, 4000);
      log.setPkDesc(str);
    } else {
      log.setPkDesc(str);
    }

    this.businessLogService.saveLog(log);
  }

  private String getUserName(String userId) {
    String userName = "";
    User user = userService.getUserById(userId);
    if (user != null) {
      userName = user.getUserName();
    }
    return userName;
  }

  private String getLangTransName(String resId) {
    String transName = "";
    Map map = langTransService.getLangTrans(resId);
    if (map.get(resId) != null) {
      transName = ((LangTrans) map.get(resId)).getResNa();
    }
    return transName;
  }

  private String getSystemTime() {
    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String time = dateFormat.format(date);
    return time;
  }

  public IBusinessLogService getBusinessLogService() {
    return businessLogService;
  }

  public void setBusinessLogService(IBusinessLogService businessLogService) {
    this.businessLogService = businessLogService;
  }

}
