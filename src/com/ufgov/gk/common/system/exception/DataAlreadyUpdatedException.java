/**
 * 
 */
package com.ufgov.gk.common.system.exception;

/**
 * @author ufwangfei
 *
 */
public class DataAlreadyUpdatedException extends DaoException {
  /**
   * 
   */
  private static final long serialVersionUID = -6065542341321221614L;

  public DataAlreadyUpdatedException() {
    super();
  }

  public DataAlreadyUpdatedException(String message) {
    super(message);
  }

  public DataAlreadyUpdatedException(String message, Throwable cause) {
    super(message, cause);
  }

  public DataAlreadyUpdatedException(Throwable cause) {
    super(cause);
  }
}
