package com.ufgov.gk.common.system.exception;

public class SecureException extends BaseException {

  private static final long serialVersionUID = -5961503614606979152L;

  public SecureException() {
    super();
  }

  public SecureException(String message) {
    super(message);
  }

  public SecureException(String message, Throwable cause) {
    super(message, cause);
  }

  public SecureException(Throwable cause) {
    super(cause);
  }
}
