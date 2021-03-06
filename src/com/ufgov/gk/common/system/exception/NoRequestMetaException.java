package com.ufgov.gk.common.system.exception;

public class NoRequestMetaException extends SecureException {

  private static final long serialVersionUID = -5961503614606979152L;

  public NoRequestMetaException() {
    super();
  }

  public NoRequestMetaException(String message) {
    super(message);
  }

  public NoRequestMetaException(String message, Throwable cause) {
    super(message, cause);
  }

  public NoRequestMetaException(Throwable cause) {
    super(cause);
  }
}
