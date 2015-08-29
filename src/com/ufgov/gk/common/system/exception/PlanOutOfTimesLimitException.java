/**
 * 
 */
package com.ufgov.gk.common.system.exception;

public class PlanOutOfTimesLimitException extends BusinessException {

  private static final long serialVersionUID = -5961503614606979152L;

  public PlanOutOfTimesLimitException() {
    super();
  }

  public PlanOutOfTimesLimitException(String message) {
    super(message);
  }

  public PlanOutOfTimesLimitException(String message, Throwable cause) {
    super(message, cause);
  }

  public PlanOutOfTimesLimitException(Throwable cause) {
    super(cause);
  }
}
