package com.ufgov.gk.common.system.exception;

/**
 * 报文返回的结果格式不对抛出的错误
 * @author liubo
 *
 */
public class MessageStructureException extends Exception {
   public MessageStructureException() {
     super();
   }
   
   public MessageStructureException(String message) {
     super(message);
   }
   
   public MessageStructureException(String message, Throwable cause) {
     super(message, cause);
   }
   
   public MessageStructureException(Throwable cause) {
     super(cause);
   }
}
