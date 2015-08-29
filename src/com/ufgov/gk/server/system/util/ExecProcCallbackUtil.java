package com.ufgov.gk.server.system.util;

import java.util.HashMap;
import java.util.Map;

import com.ufgov.gk.common.system.exception.BusinessException;
import com.ufgov.gk.server.commonbiz.dao.IExecProcCallback;
import com.ufgov.gk.server.system.SpringContext;

/**
 * 执行存储过程回调
 * @author uf-dingyy
 */
public class ExecProcCallbackUtil {
  private IExecProcCallback execProcCallbackDao = (IExecProcCallback) SpringContext
    .getBean("execProcCallbackDao");

  private static ExecProcCallbackUtil execProcCallbackUtil = new ExecProcCallbackUtil();

  private ExecProcCallbackUtil() {

  }

  public static synchronized ExecProcCallbackUtil getInstance() {
    return execProcCallbackUtil;
  }

  public void before(String xmlValue) {
    String returnInfo = null;
    Map paramMap = getParamMap();
    paramMap.put("beforeOrAfter", "before");
    paramMap.put("xmlValue", xmlValue);
    returnInfo = execProcCallbackDao.before(paramMap);
    if (returnInfo != null) {
      throw new BusinessException(returnInfo.toString());
    }
  }

  public void after(String xmlValue) {
    String returnInfo = null;
    Map paramMap = getParamMap();
    paramMap.put("beforeOrAfter", "after");
    paramMap.put("xmlValue", xmlValue);
    returnInfo = execProcCallbackDao.after(paramMap);
    if (returnInfo != null) {
      throw new BusinessException(returnInfo.toString());
    }
  }

  private Map getParamMap() {
    Map paramMap = new HashMap();
    paramMap.put("compoId", RequestMetaUtil.getCompoId());
    paramMap.put("svUserId", RequestMetaUtil.getSvUserID());
    paramMap.put("svFuncId", RequestMetaUtil.getFuncId());
    paramMap.put("svCoCode", RequestMetaUtil.getSvCoCode());
    paramMap.put("svTraDate", RequestMetaUtil.getTransDate());
    paramMap.put("extParam1", "");
    paramMap.put("extParam2", "");
    paramMap.put("info", "");
    return paramMap;
  }
}
