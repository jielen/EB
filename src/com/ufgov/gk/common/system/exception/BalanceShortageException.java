/**
 * 
 */
package com.ufgov.gk.common.system.exception;

public class BalanceShortageException extends BusinessException {

  private static final long serialVersionUID = -5961503614606979152L;

  public BalanceShortageException() {
    super();
  }

  public BalanceShortageException(String message) {
    super(message);
  }

  public BalanceShortageException(String message, Throwable cause) {
    super(message, cause);
  }

  public BalanceShortageException(Throwable cause) {
    super(cause);
  }
}
