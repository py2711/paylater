package com.simpl.paylater.service.report;

import com.simpl.paylater.dto.ReportMerchantDiscountRequest;
import com.simpl.paylater.dto.ReportUserDuesRequest;
import com.simpl.paylater.model.Merchant;
import com.simpl.paylater.model.User;
import com.simpl.paylater.repository.UserRepository;
import com.simpl.paylater.utils.MerchantUtilService;
import com.simpl.paylater.utils.UserUtilService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

  @Autowired
  private MerchantUtilService merchantUtilService;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserUtilService userUtilService;

  public double discountProvidedMerchant(ReportMerchantDiscountRequest request) {
    Merchant merchant = merchantUtilService.checkMerchantExist(request.getMerchant());
    return merchant.getDiscountProvided();
  }

  public double userDues(ReportUserDuesRequest request) {
    User user = userUtilService.checkUserExist(request.getUser());
    return user.getOutstandingBalance();
  }

  public List<User> userAtCreditLimit() {
    return userRepository.fetchUsersAtCreditLimit().orElse(null);
  }

  public List<User> allUserDues() {
    // TODO pagination needs to be applied
    return userRepository.fetchUsersHavingDues().orElse(null);
  }
}
