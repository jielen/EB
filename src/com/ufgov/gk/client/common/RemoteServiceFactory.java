package com.ufgov.gk.client.common;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import com.caucho.hessian.client.HessianProxyFactory;

public class RemoteServiceFactory {

  private static HessianProxyFactory factory;

  private static Map remoteServiceMap = new HashMap();

  public synchronized static Object create(Class c, String serviceName) {
    Object service = null;

    if (factory == null) {
      factory = new HessianProxyFactory();
      factory.setOverloadEnabled(true);
    }
    try {
      if (remoteServiceMap.get(c.getName()) == null) {
        String url = WorkEnv.getInstance().getServiceRoot() + "/" + serviceName;
        service = factory.create(c, url);
        remoteServiceMap.put(c.getName(), service);
      } else {
        service = remoteServiceMap.get(c.getName());
      }
    } catch (MalformedURLException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
    return service;
  }
}
