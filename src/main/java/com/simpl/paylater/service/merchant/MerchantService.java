
package com.simpl.paylater.service.merchant;

import com.simpl.paylater.dto.MerchantOnboardRequest;
import com.simpl.paylater.dto.UpdateMerchantDiscountRequest;
import com.simpl.paylater.model.Merchant;

import org.springframework.stereotype.Service;

@Service
public interface MerchantService {
  public Merchant onboardNewMerchant(MerchantOnboardRequest request);

  public Merchant updateDiscount(UpdateMerchantDiscountRequest request);

}
