
package com.simpl.paylater.controller;

import com.simpl.paylater.dto.ReportMerchantDiscountRequest;
import com.simpl.paylater.exception.InvalidRequestException;
import com.simpl.paylater.pojo.Arguments;
import com.simpl.paylater.service.report.ReportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("ReportMerchantDiscount")
public class ReportMerchantDiscount implements Command {

  @Autowired
  private ReportService reportService;

  @Override
  public String execute(Arguments arguments) {
    ReportMerchantDiscountRequest request = new ReportMerchantDiscountRequest(arguments.getArgument().get(2));
    double discount = reportService.discountProvidedMerchant(request);
    return String.valueOf(discount);
  }

  @Override
  public void validateRequest(Arguments arguments) {
    if (arguments.getArgument().size() != 3) {
      throw new InvalidRequestException("Invalid update merchant discount request , check passed arguments");
    }
  }
}
