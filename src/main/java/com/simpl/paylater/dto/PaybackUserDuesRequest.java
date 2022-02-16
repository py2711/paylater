
package com.simpl.paylater.dto;

import com.simpl.paylater.exception.InvalidRequestException;

import java.util.List;

/**
 * Request class to payback user debt
 */
public class PaybackUserDuesRequest {

  private String user;
  private double amount;

  public PaybackUserDuesRequest(String user, double amount) {
    this.user = user;
    this.amount = amount;
  }

  public static PaybackUserDuesRequest build(List<String> arguments) {
    String name = arguments.get(1);
    float paybackAmount;
    try {
      paybackAmount = Float.parseFloat(arguments.get(2));
    } catch (NumberFormatException e) {
      throw new InvalidRequestException("Invalid request");
    }
    return new PaybackUserDuesRequest(name, paybackAmount);
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
    return "PaybackUserDuesRequest{" + "user='" + user + '\'' + ", amount=" + amount + '}';
  }
}
