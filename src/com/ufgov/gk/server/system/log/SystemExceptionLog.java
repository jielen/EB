package com.ufgov.gk.server.system.log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;

import com.ufgov.gk.common.system.exception.BaseException;
import com.ufgov.gk.common.system.exception.OtherException;

public class SystemExceptionLog implements ThrowsAdvice {

  private static final Logger logger = Logger.getLogger(SystemExceptionLog.class);

  public void afterThrowing(Method m, Object[] args, Object target, Throwable e) throws Throwable {

    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    e.printStackTrace(pw);

    if (!(e instanceof BaseException)) {

      logger.error(e.getMessage(), e);

      OtherException otherException = new OtherException(e.getMessage() );
      otherException.setStackTraceMessage(sw.toString());
      throw otherException;
      
    } else {

      BaseException oldException = (BaseException) e;

      if (oldException.getStackTraceMessage() == null || oldException.getStackTraceMessage().trim().equals("")) {
        logger.error(e.getMessage(), e);
      } else {
        logger.error(oldException.getStackTraceMessage(), oldException);
      }

      Class[] parameterTypes = { String.class };
      Object[] params = { e.getMessage() };

      BaseException newException = (BaseException) (Class.forName(e.getClass().getName())
        .getConstructor(parameterTypes).newInstance(params));

      if (oldException.getStackTraceMessage() == null || oldException.getStackTraceMessage().trim().equals("")) {
        newException.setStackTraceMessage(sw.toString());
      } else {
        newException.setStackTraceMessage(oldException.getStackTraceMessage());
      }

      throw newException;
    }

  }
}
