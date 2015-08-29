/**
 * 
 */
package com.ufgov.gk.common.system.exception;

/**
 * @author ufwangfei
 *
 */
public class DaoException extends BaseException {
  /**
   * 
   */
  private static final long serialVersionUID = -8305560093773322074L;

  public DaoException() {
    super();
  }

  public DaoException(String message) {
    super(message);
  }

  public DaoException(String message, Throwable cause) {
    super(message, cause);
  }

  public DaoException(Throwable cause) {
    super(cause);
  }
}
