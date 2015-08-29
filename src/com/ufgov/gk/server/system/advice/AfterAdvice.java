package com.ufgov.gk.server.system.advice;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.server.system.util.ExecProcCallbackUtil;

public class AfterAdvice implements AfterReturningAdvice {

  private static final Logger logger = Logger.getLogger(AfterAdvice.class);

  public void afterReturning(Object returnValue, Method method, Object[] args, Object target)
    throws Throwable {
    StringBuffer info = new StringBuffer("类--" + target.getClass().getName() + " 方法--" + method.getName()
      + " 参数类型--");
    for (int i = 0; i < args.length; i++) {
      if (args[i] != null) {
        info.append(" " + i + " " + args[i].getClass().getName());
      } else {
        info.append(" " + i + " " + args[i]);
      }
    }
    if (logger.isDebugEnabled()) {
      logger.debug("AfterAdvice - 开始");
    }

    StringBuffer billElementXml = new StringBuffer();
    billElementXml.append("<FIELDS>\n");
    for (int i = 0; i < args.length; i++) {
      if (args[i] instanceof BaseBill) {
        billElementXml.append(((BaseBill) args[i]).toXml());
        break;
      } else if (args[i] instanceof List) {
        List list = ((List) args[i]);
        if (!list.isEmpty() && list.get(0) instanceof BaseBill) {
          for (int n = 0; n < list.size(); n++) {
            billElementXml.append(((BaseBill)list.get(n)).toXml());
          }
        }
      }
    }
    billElementXml.append("</FIELDS>\n");
    ExecProcCallbackUtil.getInstance().after(billElementXml.toString());
    if (logger.isDebugEnabled()) {
      logger.debug("AfterAdvice - 结束");
    }

  }
}
