
package com.simpl.paylater.utils;

import com.simpl.paylater.exception.PayLaterException;
import com.simpl.paylater.model.Merchant;
import com.simpl.paylater.repository.MerchantRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantUtilService {

  @Autowired
  private MerchantRepository merchantRepository;

  public Merchant getMerchantByName(String name) {
    Optional<Merchant> merchant = merchantRepository.findById(name);
    return merchant.orElse(null);
  }

  public Merchant checkMerchantExist(String name) {
    Merchant merchantByName = getMerchantByName(name);
    if (merchantByName == null) {
      throw new PayLaterException("Merchant doesn't exist");
    }
    return merchantByName;
  }

  public Merchant persist(Merchant merchant) {
    return merchantRepository.save(merchant);
  }

  public Merchant updateDiscountProvidedTillNow(Merchant merchant, double discountProvided) {
    merchant.setDiscountProvided(merchant.getDiscountProvided() + discountProvided);
    return persist(merchant);
  }
}
