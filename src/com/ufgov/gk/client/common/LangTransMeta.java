package com.ufgov.gk.client.common;

import java.util.HashMap;
import java.util.Map;

import com.ufgov.gk.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.model.LangTrans;

public class LangTransMeta {

  private static Map langTransMap = new HashMap();

  private static Map generatedResIds = new HashMap();

  public synchronized static void init(String resId) {
    if (generatedResIds.get(resId) == null) {
      IBaseDataServiceDelegate baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory
        .create(IBaseDataServiceDelegate.class, "baseDataServiceDelegate");

      RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();
      langTransMap.putAll(baseDataServiceDelegate.getLangTrans(resId, requestMeta));
      generatedResIds.put(resId, resId);
    }
  }

  public synchronized static String translate(String resId) {

    String temp = resId;
    LangTrans langTrans = (LangTrans) langTransMap.get(temp);
    if (langTrans != null) {
      temp = langTrans.getResNa();
    }
    return temp;
  }


}
