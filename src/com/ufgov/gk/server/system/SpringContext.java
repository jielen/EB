package com.ufgov.gk.server.system;

import org.springframework.context.ApplicationContext;

public class SpringContext {
  private static ApplicationContext _springContext = null;

  public static void setSpringContext(ApplicationContext context) {
    _springContext = context;
  }

  public static ApplicationContext getSpringContext() {
    return _springContext;
  }

  public static Object getBean(String beanId) {
    return _springContext.getBean(beanId);
  }
}
