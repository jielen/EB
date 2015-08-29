/**
 * 
 */
package com.ufgov.gk.common.system.exception;

/**
 * @author ufwangfei
 *
 */
public class BaseException extends RuntimeException {

  private static final long serialVersionUID = -4983815481832335822L;
  
  protected String stackTraceMessage;

  /**客户端写日志时应调用这个函数 ，这样可以把服务器端的异常堆栈信息带到客户端。
   * 例如 logger.error(e.getStackTraceMessage(), e); 
   * @param stackTraceMessage
   */
  public String getStackTraceMessage() {
    return stackTraceMessage;
  }

  public void setStackTraceMessage(String stackTraceMessage) {
    this.stackTraceMessage = stackTraceMessage;
  }


  public BaseException() {
    super();
  }

  public BaseException(String message) {
    super(message);
  }

  public BaseException(String message, Throwable cause) {
    super(message, cause);
  }

  public BaseException(Throwable cause) {
    super(cause);
  }
}
