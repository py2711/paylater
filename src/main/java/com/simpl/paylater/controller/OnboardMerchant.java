
package com.simpl.paylater.controller;

import com.simpl.paylater.dto.MerchantOnboardRequest;
import com.simpl.paylater.exception.InvalidRequestException;
import com.simpl.paylater.model.Merchant;
import com.simpl.paylater.pojo.Arguments;
import com.simpl.paylater.service.merchant.MerchantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("OnboardMerchant")
public class OnboardMerchant implements Command {

  @Autowired
  private MerchantService merchantOnBoardingService;

  @Override
  public String execute(Arguments arguments) {
    MerchantOnboardRequest request = MerchantOnboardRequest.build(arguments.getArgument());
    Merchant merchant = merchantOnBoardingService.onboardNewMerchant(request);
    return merchant.getName() + "(" + merchant.getDiscountPercent() + ")";
  }

  @Override
  public void validateRequest(Arguments arguments) {
    if (arguments.getArgument().size() != 5) {
      throw new InvalidRequestException("Invalid Onboard merchant request , check passed arguments");
    }
  }
}
