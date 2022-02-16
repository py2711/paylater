
package com.simpl.paylater.dto;

/**
 * Request class to update user credit limit
 */
public class UpdateUserCreditRequest {

  private String user;
  private double amount;

  public UpdateUserCreditRequest(String user, double amount) {
    this.user = user;
    this.amount = amount;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "UpdateUserCreditRequest{" + "user='" + user + '\'' + ", amount=" + amount + '}';
  }
}
