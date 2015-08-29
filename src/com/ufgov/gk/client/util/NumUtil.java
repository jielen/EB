package com.ufgov.gk.client.util;

import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.gk.common.system.RequestMeta;

public class NumUtil {
  private static IBaseDataServiceDelegate  baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(
    IBaseDataServiceDelegate.class, "baseDataServiceDelegate");

  public static  String getNum(String compoId, String noField, Object bill, RequestMeta requestMeta) {
    return baseDataServiceDelegate.getNo(compoId, noField, bill, requestMeta);
  }
}
