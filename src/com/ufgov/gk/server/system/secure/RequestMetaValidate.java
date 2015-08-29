package com.ufgov.gk.server.system.secure;

import org.apache.log4j.Logger;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.exception.NoRequestMetaException;


public class RequestMetaValidate implements MethodBeforeAdvice {

  private static final Logger logger = Logger.getLogger(RequestMetaValidate.class);

  public void before(Method method, Object[] args, Object target) throws Throwable {
    
    String classInfo="class:"+target.getClass().getName()+" method:"+method.getName();
    
    if (logger.isDebugEnabled()) {
      logger.debug("检查RequestMeta参数开始--"+classInfo);
    }

    boolean find = false;
    
    for (int i = 0; i < args.length; i++) {
      if (args[i] instanceof RequestMeta) {
        find = true;
        break;
      }
    }

    if (!find) {
      throw new NoRequestMetaException("没有找到RequestMeta--"+classInfo);
    }

    if (logger.isDebugEnabled()) {
      logger.debug("检查RequestMeta参数通过--"+classInfo);
    }
  }
}
