package com.ufgov.gk.server.system.secure;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.exception.SecureException;

public class Authentication implements MethodBeforeAdvice {

  private static final Logger logger = Logger.getLogger(Authentication.class);

  public void before(Method method, Object[] args, Object target) throws Throwable {
    if (logger.isDebugEnabled()) {
      logger.debug("Authentication ��ʼ..");
    }
    
    StringBuffer info = new StringBuffer(" ����:��--" + target.getClass().getName() + " ����--" + method.getName()+" ��������--");
    
    for (int i = 0; i < args.length; i++) {
      if(args[i]!=null){
        info.append(" "+i+" "+args[i].getClass().getName());
      }else{
        info.append(" "+i+" "+args[i]);
      }
     
    }
    
    for (int i = 0; i < args.length; i++) {

      if (args[i] instanceof RequestMeta) {

        RequestMeta requestMeta = (RequestMeta) args[i];
        this.validateToken(requestMeta.getToken());
        this.validateIP(requestMeta.getClientIP());
        this.validateUser(requestMeta.getSvUserID());

        if (logger.isDebugEnabled()) {
          logger.debug("���ӵ� token:" + requestMeta.getToken() + " clientIP:"
            + requestMeta.getClientIP() + " userId:" + requestMeta.getSvUserID()
            + info);
        }

        break;
      }
    }

    if (logger.isDebugEnabled()) {
      logger.debug("Authentication ͨ��");
    }
  }

  /**
   * ��ʵ���д�������
   * @param token
   */
  private void validateToken(String token) {
    if (token == null || token.trim().equals("")) {
      throw new SecureException("RequestMetaû��token��Ϣ��ֹ����");
    }

  }

  private void validateIP(String ip) {

  }

  /**
   * ��ʵ���д�������
   * @param userId
   */
  private void validateUser(String userId) {
    if (userId == null || userId.trim().equals("")) {
      throw new SecureException("RequestMetaû��UserId��Ϣ��ֹ����");
    }

  }

}
