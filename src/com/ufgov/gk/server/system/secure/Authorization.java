package com.ufgov.gk.server.system.secure;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

import com.ufgov.gk.common.system.dto.UserFuncDto;
import com.ufgov.gk.common.system.exception.SecureException;
import com.ufgov.gk.common.system.model.AsCompo;
import com.ufgov.gk.common.system.model.UserFunc;
import com.ufgov.gk.server.system.service.IAsCompoService;
import com.ufgov.gk.server.system.service.IUserFuncService;
import com.ufgov.gk.server.system.util.RequestMetaUtil;

public class Authorization implements MethodBeforeAdvice {

  private IUserFuncService userFuncService;

  private IAsCompoService asCompoService;

  private static final Logger logger = Logger.getLogger(Authorization.class);

  public void before(Method method, Object[] args, Object target) throws Throwable {
    if (!isFuncControl(RequestMetaUtil.getCompoId())) {
      return;
    }

    if (logger.isDebugEnabled()) {
      logger.debug("Authorization 开始");
    }

    validateUserFunc(this.getCurrUserFunc());

    if (logger.isDebugEnabled()) {
      logger.debug("Authorization 通过");
    }

  }

  private void validateUserFunc(UserFunc userFunc) {

    UserFuncDto userFuncDto = new UserFuncDto();

    userFuncDto.setUserId(RequestMetaUtil.getSvUserID());
    userFuncDto.setCompoId(RequestMetaUtil.getCompoId());
    userFuncDto.setCoCode(RequestMetaUtil.getSvCoCode());
    userFuncDto.setOrgCode(RequestMetaUtil.getSvOrgCode());
    userFuncDto.setPosiCode(RequestMetaUtil.getSvPoCode());

    List list = userFuncService.getUserGrantFunc(userFuncDto);

    if ((userFunc.getFuncId() != null && userFunc.getFuncId().length() > 0) && !list.contains(userFunc)) {
      throw new SecureException("用户id:" + userFunc.getUserId()
        + " 没有相应的功能权限: compoId--" + userFunc.getCompoId() + " funcId--"
        + userFunc.getFuncId());
    }

  }

  private UserFunc getCurrUserFunc() {

    UserFunc userFunc = new UserFunc();
    userFunc.setUserId(RequestMetaUtil.getSvUserID());
    userFunc.setCompoId(RequestMetaUtil.getCompoId());
    userFunc.setFuncId(RequestMetaUtil.getFuncId());

    return userFunc;
  }

  public IUserFuncService getUserFuncService() {
    return userFuncService;
  }

  public void setUserFuncService(IUserFuncService userFuncService) {
    this.userFuncService = userFuncService;
  }

  private boolean isFuncControl(String compoId) {
    boolean funcControl = false;
    AsCompo value = asCompoService.getAsCompoById(compoId);
    if (value != null && "Y".equalsIgnoreCase(value.getFuncControl())) {
      funcControl = true;
    }
    return funcControl;
  }

  public IAsCompoService getAsCompoService() {
    return asCompoService;
  }

  public void setAsCompoService(IAsCompoService asCompoService) {
    this.asCompoService = asCompoService;
  }

}
