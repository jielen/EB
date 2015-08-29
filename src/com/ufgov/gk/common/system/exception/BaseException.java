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

  /**�ͻ���д��־ʱӦ����������� ���������԰ѷ������˵��쳣��ջ��Ϣ�����ͻ��ˡ�
   * ���� logger.error(e.getStackTraceMessage(), e); 
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
