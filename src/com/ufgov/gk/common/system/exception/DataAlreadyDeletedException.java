/**
 * 
 */
package com.ufgov.gk.common.system.exception;

/**
 * @author ufwangfei
 *
 */
public class DataAlreadyDeletedException extends DaoException {

  private static final long serialVersionUID = -5090304378625417723L;

  public DataAlreadyDeletedException() {
    super();
  }

  public DataAlreadyDeletedException(String message) {
    super(message);
  }

  public DataAlreadyDeletedException(String message, Throwable cause) {
    super(message, cause);
  }

  public DataAlreadyDeletedException(Throwable cause) {
    super(cause);
  }
}
