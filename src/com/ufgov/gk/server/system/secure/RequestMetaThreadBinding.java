package com.ufgov.gk.server.system.secure;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.server.system.ThreadLocalContext;

public class RequestMetaThreadBinding implements MethodBeforeAdvice {

  private static final Logger logger = Logger
    .getLogger(RequestMetaThreadBinding.class);

  public void before(Method method, Object[] args, Object target) throws Throwable {

    if (logger.isDebugEnabled()) {
      logger.debug("�ReqestMeta����ǰ�߳̿�ʼ--"+Thread.currentThread());
    }

    ThreadLocalContext.set(new HashMap());

    for (int i = 0; i < args.length; i++) {
      if (args[i] instanceof RequestMeta) {
        ThreadLocalContext.setAttribute(RequestMeta.class.getName(), args[i]);
        break;
      }
    }

    if (logger.isDebugEnabled()) {
      logger.debug("�ReqestMeta����ǰ�߳̽���--"+Thread.currentThread());
    }
  }
}
