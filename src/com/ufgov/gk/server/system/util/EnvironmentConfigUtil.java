package com.ufgov.gk.server.system.util;

import com.ufgov.gk.server.system.EnvironmentConfig;
import com.ufgov.gk.server.system.SpringContext;

public class EnvironmentConfigUtil {

  private EnvironmentConfig environmentConfig = (EnvironmentConfig) SpringContext
    .getBean("environmentConfigGk");

  private static EnvironmentConfigUtil environmentConfigUtil;

  public String get(String key) {
    return environmentConfig.get(key);
  }

  public synchronized static EnvironmentConfigUtil getInstance() {
    if (environmentConfigUtil == null) {
      environmentConfigUtil = new EnvironmentConfigUtil();
    }
    return environmentConfigUtil;
  }

}
