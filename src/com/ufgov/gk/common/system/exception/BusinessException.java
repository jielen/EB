/**
 * 
 */
package com.ufgov.gk.common.system.exception;

/**
 * @author ufwangfei
 *
 */
public class BusinessException extends BaseException {

  private static final long serialVersionUID = -5961503614606979152L;

  public BusinessException() {
    super();
  }

  public BusinessException(String message) {
    super(message);
  }

  public BusinessException(String message, Throwable cause) {
    super(message, cause);
  }

  public BusinessException(Throwable cause) {
    super(cause);
  }
}
