package com.ufgov.gk.client.datacache;

import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.common.commonbiz.publish.IBaseDataServiceDelegate;

public class Util {
  public static  IBaseDataServiceDelegate baseDataServiceDelegate=(IBaseDataServiceDelegate) ServiceFactory
  .create(IBaseDataServiceDelegate.class, "baseDataServiceDelegate");

}
