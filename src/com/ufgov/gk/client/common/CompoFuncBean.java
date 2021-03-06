package com.ufgov.gk.client.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ufgov.gk.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.gk.common.system.RequestMeta;

public class CompoFuncBean {

  private static Map<String, List> dataMap = new HashMap<String, List>();

  public synchronized static boolean isUsed(String compoId, String funcId) {

    if (dataMap.get(compoId) == null) {

      IBaseDataServiceDelegate baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory
        .create(IBaseDataServiceDelegate.class, "baseDataServiceDelegate");

      WorkEnv workEnv = WorkEnv.getInstance();
      RequestMeta requestMeta = workEnv.getRequestMeta();

      List usedFuncList = baseDataServiceDelegate.getUsedCompoFunc(compoId,
        requestMeta);

      dataMap.put(compoId, usedFuncList);
    }

    if (((List) dataMap.get(compoId)).contains(funcId)) {
      return true;
    }
    return false;
  }

}
