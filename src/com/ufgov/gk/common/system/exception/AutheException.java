package com.ufgov.gk.common.system.exception;

/**
 * 客户端的服务配置文件错误
 * @author liubo
 *
 */
public class AutheException extends Exception {
   public AutheException() {
     super();
   }
   
   public AutheException(String message) {
     super(message);
   }
   
   public AutheException(String message, Throwable cause) {
     super(message, cause);
   }
   
   public AutheException(Throwable cause) {
     super(cause);
   }
}
