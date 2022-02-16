
package com.simpl.paylater.dto;

import com.simpl.paylater.exception.InvalidRequestException;

import java.util.List;

/**
 * Request class to onboard new merchant
 */
public class MerchantOnboardRequest {
  /*
   * Merchant email
   */
  private String email;

  /*
   * Merchant name
   */
  private String name;

  /*
   * Store discount percent provided by merchant
   */
  private float discountPercent;

  public MerchantOnboardRequest(String name, String email, float discountPercent) {
    this.email = email;
    this.name = name;
    this.discountPercent = discountPercent;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getDiscountPercent() {
    return discountPercent;
  }

  public void setDiscountPercent(float discountPercent) {
    this.discountPercent = discountPercent;
  }

  public static MerchantOnboardRequest build(List<String> arguments) {
    String name = arguments.get(2);
    String email = arguments.get(3);
    float discountPercent;
    try {
      discountPercent = Float.parseFloat(arguments.get(4));
    } catch (NumberFormatException e) {
      throw new InvalidRequestException("Invalid Reuest");
    }
    return new MerchantOnboardRequest(name, email, discountPercent);
  }

  @Override
  public String toString() {
    return "MerchantOnboardRequest{" + "email='" + email + '\'' + ", name='" + name + '\'' + ", discountPercent="
        + discountPercent + '}';
  }
}
