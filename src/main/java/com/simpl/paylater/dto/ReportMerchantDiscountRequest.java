
package com.simpl.paylater.dto;

/**
 * Request class to report merchant discount
 */
public class ReportMerchantDiscountRequest {

  private String merchant;

  public ReportMerchantDiscountRequest(String merchant) {
    this.merchant = merchant;
  }

  public String getMerchant() {
    return merchant;
  }

  public void setMerchant(String merchant) {
    this.merchant = merchant;
  }

  @Override
  public String toString() {
    return "MerchantDiscountReportRequest{" + "merchant='" + merchant + '\'' + '}';
  }
}
