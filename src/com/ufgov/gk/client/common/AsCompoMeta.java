package com.ufgov.gk.client.common;

import java.util.HashMap;
import java.util.Map;

import com.ufgov.gk.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.model.AsCompo;

public class AsCompoMeta {

  private static Map dataMap = new HashMap();

  public  static boolean isFuncControl(String compoId) {
     boolean funcControl=false;
    AsCompo value = getAsCompo(compoId);
    if (value != null&&"Y".equalsIgnoreCase(value.getFuncControl())) {
      funcControl=true;
    }
    return funcControl;
  }

  public synchronized static AsCompo getAsCompo(String compoId) {
    AsCompo value = (AsCompo) dataMap.get(compoId);
    if (value == null) {
      IBaseDataServiceDelegate baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(
        IBaseDataServiceDelegate.class, "baseDataServiceDelegate");
       RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();
      value = baseDataServiceDelegate.getAsCompoById(compoId, requestMeta);
      dataMap.put(compoId, value);
    }
    return value;
  }
}
