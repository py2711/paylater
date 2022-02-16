package com.simpl.paylater.pojo;

/**
 * The predefined credit decision values.
 */
public enum CreditDecisionEnum {

  /**
   * The request was accepted.
   */
  ACCEPTED(true, "success!"),

  /**
   * The request was rejected due to high purchase amount.
   */
  CREDIT_LIMITED_BREACHED(false, "rejected! (reason: credit limit)");

  private final boolean accepted;

  private final String message;

  CreditDecisionEnum(boolean accepted, String message) {
    this.accepted = accepted;
    this.message = message;
  }

  public boolean isAccepted() {
    return accepted;
  }

  public String getMessage() {
    return message;
  }
}
