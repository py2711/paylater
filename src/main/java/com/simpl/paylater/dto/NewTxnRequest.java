
package com.simpl.paylater.dto;

import com.simpl.paylater.exception.InvalidRequestException;

import java.util.List;

/**
 * Request class to process new txn
 */
public class NewTxnRequest {

  private String user;
  private String merchant;
  private double amount;

  public NewTxnRequest(String user, String merchant, double amount) {
    this.user = user;
    this.merchant = merchant;
    this.amount = amount;
  }

  public static NewTxnRequest build(List<String> arguments) {
    String user = arguments.get(2);
    String merchant = arguments.get(3);
    float amount;
    try {
      amount = Float.parseFloat(arguments.get(4));
    } catch (NumberFormatException e) {
      throw new InvalidRequestException("Invalid Reuest");
    }
    return new NewTxnRequest(user, merchant, amount);
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getMerchant() {
    return merchant;
  }

  public void setMerchant(String merchant) {
    this.merchant = merchant;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "NewTxnRequest{" + "user='" + user + '\'' + ", merchant='" + merchant + '\'' + ", amount=" + amount + '}';
  }
}
