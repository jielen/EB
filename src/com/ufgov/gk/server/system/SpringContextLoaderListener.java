package com.ufgov.gk.server.system;

import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringContextLoaderListener extends ContextLoaderListener {

  public void contextInitialized(ServletContextEvent event) {
    super.contextInitialized(event);
    ApplicationContext context = WebApplicationContextUtils
      .getWebApplicationContext(event.getServletContext());
    SpringContext.setSpringContext(context);
  }
  
}
