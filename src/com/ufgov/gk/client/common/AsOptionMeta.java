package com.ufgov.gk.client.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ufgov.gk.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.model.AsOption;

public class AsOptionMeta {

  private static Map asOptionMap = new HashMap();

  public synchronized static String getOptVal(String optId) {

    String optVal = "";
    AsOption asOption = getAsOption(optId);
    if (asOption != null) {
      optVal = asOption.getOptVal();
    }
    return optVal == null ? "" : optVal;
  }

  public synchronized static List getAllAsOptionById(String optId) {
    IBaseDataServiceDelegate baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(IBaseDataServiceDelegate.class,
      "baseDataServiceDelegate");
    RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();
    return baseDataServiceDelegate.getAllAsOptionById(optId, requestMeta);
  }

  private static AsOption getAsOption(String optId) {
    AsOption asOption = (AsOption) asOptionMap.get(optId);
    if (asOption == null) {
      IBaseDataServiceDelegate baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(IBaseDataServiceDelegate.class,
        "baseDataServiceDelegate");

      RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();

      asOption = baseDataServiceDelegate.getAsOption(optId, requestMeta);
      asOptionMap.put(optId, asOption);
    }
    return asOption;
  }

  public synchronized static void updateOptVal(String optId, String optVal) {
    IBaseDataServiceDelegate baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(IBaseDataServiceDelegate.class,
      "baseDataServiceDelegate");
    AsOption asOption = getAsOption(optId);
    asOption.setOptVal(optVal);
    RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();
    baseDataServiceDelegate.updateOptionVal(asOption, requestMeta);
    asOptionMap.put(optId, asOption);
  }

}
