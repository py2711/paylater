
package com.simpl.paylater.service.merchant;

import com.simpl.paylater.dto.MerchantOnboardRequest;
import com.simpl.paylater.dto.UpdateMerchantDiscountRequest;
import com.simpl.paylater.exception.PayLaterException;
import com.simpl.paylater.model.Merchant;
import com.simpl.paylater.utils.MerchantUtilService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements MerchantService {

  @Autowired
  private MerchantUtilService merchantUtilService;

  @Override
  public Merchant onboardNewMerchant(MerchantOnboardRequest request) {
    Merchant merchant = new Merchant(request.getEmail(), request.getName(), request.getDiscountPercent());
    if (merchantUtilService.getMerchantByName(merchant.getName()) != null) {
      throw new PayLaterException("rejected! (reason: merchant already exists)");
    }
    Merchant insertMerchant;
    try {
      insertMerchant = merchantUtilService.persist(merchant);
    } catch (DataIntegrityViolationException e) {
      throw new PayLaterException("rejected! (reason: merchant already exists)");
    }
    return insertMerchant;
  }

  @Override
  public Merchant updateDiscount(UpdateMerchantDiscountRequest request) {
    Merchant merchant = merchantUtilService.getMerchantByName(request.getMerchant());
    if (merchant == null) {
      throw new PayLaterException("rejected! (reason: merchant doesn't exists)");
    }
    merchant.setDiscountPercent(request.getDiscount());
    merchant = merchantUtilService.persist(merchant);
    return merchant;
  }

}
