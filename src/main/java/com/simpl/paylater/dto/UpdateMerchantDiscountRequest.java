
package com.simpl.paylater.dto;

/**
 * Request class to update merchant discount
 */
public class UpdateMerchantDiscountRequest {
  private String merchant;
  private float discount;

  public UpdateMerchantDiscountRequest(String merchant, float discount) {
    this.merchant = merchant;
    this.discount = discount;
  }

  public String getMerchant() {
    return merchant;
  }

  public void setMerchant(String merchant) {
    this.merchant = merchant;
  }

  public float getDiscount() {
    return discount;
  }

  public void setDiscount(float discount) {
    this.discount = discount;
  }

  @Override
  public String toString() {
    return "UpdateMerchantDiscountRequest{" + "merchant='" + merchant + '\'' + ", discount=" + discount + '}';
  }
}
