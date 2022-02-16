
package com.simpl.paylater.dto;

import com.simpl.paylater.exception.InvalidRequestException;

import java.util.List;

/**
 * API request class to onboard new user
 */
public class UserOnboardRequest {

  private String name;
  private String email;
  private double creditLimit;

  public UserOnboardRequest(String name, String email, double creditLimit) {
    this.name = name;
    this.email = email;
    this.creditLimit = creditLimit;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public double getCreditLimit() {
    return creditLimit;
  }

  public void setCreditLimit(double creditLimit) {
    this.creditLimit = creditLimit;
  }

  public static UserOnboardRequest build(List<String> arguments) {
    String name = arguments.get(2);
    String email = arguments.get(3);
    float creditLimit;
    try {
      creditLimit = Float.parseFloat(arguments.get(4));
    } catch (NumberFormatException e) {
      throw new InvalidRequestException("Invalid request");
    }
    return new UserOnboardRequest(name, email, creditLimit);
  }

  @Override
  public String toString() {
    return "UserOnboardRequest{" + "name='" + name + '\'' + ", email='" + email + '\'' + ", creditLimit=" + creditLimit + '}';
  }
}
