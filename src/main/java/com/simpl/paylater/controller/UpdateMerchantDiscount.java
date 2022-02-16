
package com.simpl.paylater.controller;

import com.simpl.paylater.dto.UpdateMerchantDiscountRequest;
import com.simpl.paylater.exception.InvalidRequestException;
import com.simpl.paylater.pojo.Arguments;
import com.simpl.paylater.service.merchant.MerchantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("UpdateMerchantDiscount")
public class UpdateMerchantDiscount implements Command {

  @Autowired
  private MerchantService merchantService;

  @Override
  public String execute(Arguments arguments) {
    UpdateMerchantDiscountRequest request =
        new UpdateMerchantDiscountRequest(arguments.getArgument().get(2), Float.parseFloat(arguments.getArgument().get(3)));
    merchantService.updateDiscount(request);
    return request.getMerchant() + "(" + request.getDiscount() + ")";
  }

  @Override
  public void validateRequest(Arguments arguments) {
    if (arguments.getArgument().size() != 4) {
      throw new InvalidRequestException("Invalid update merchant discount request , check passed arguments");
    }
  }
}
