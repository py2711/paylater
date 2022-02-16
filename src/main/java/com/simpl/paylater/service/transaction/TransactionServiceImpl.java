
package com.simpl.paylater.service.transaction;

import com.simpl.paylater.dto.NewTxnRequest;
import com.simpl.paylater.model.Merchant;
import com.simpl.paylater.model.Transaction;
import com.simpl.paylater.model.User;
import com.simpl.paylater.pojo.CreditDecisionEnum;
import com.simpl.paylater.service.decision.CreditDecisionService;
import com.simpl.paylater.utils.MerchantUtilService;
import com.simpl.paylater.utils.TransactionUtilService;
import com.simpl.paylater.utils.UserUtilService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

  @Autowired
  TransactionUtilService transactionUtilService;

  @Autowired
  private UserUtilService userUtilService;

  @Autowired
  private MerchantUtilService merchantUtilService;

  @Autowired
  private CreditDecisionService creditDecisionService;

  @Override
  public Transaction processTxn(NewTxnRequest request) {
    User user = userUtilService.checkUserExist(request.getUser());
    Merchant merchantByName = merchantUtilService.checkMerchantExist(request.getMerchant());
    /*
     * get credit decision
     */
    CreditDecisionEnum creditDecision = creditDecisionService.getCreditDecision(user, request.getAmount());

    double discountProvided = getDiscountProvided(merchantByName, request.getAmount());

    Transaction transaction =
        new Transaction(request.getAmount(), discountProvided, request.getUser(), request.getMerchant(), creditDecision);
    if (creditDecision.isAccepted()) {
      merchantUtilService.updateDiscountProvidedTillNow(merchantByName, discountProvided);
      userUtilService.updateOutstanding(user, request.getAmount());
    }
    return transactionUtilService.persistTransaction(transaction);
  }

  private double getDiscountProvided(Merchant merchant, double txnAmount) {
    float discountPercent = merchant.getDiscountPercent();
    double discountProvided = (txnAmount * discountPercent) / 100;
    return discountProvided;
  }
}
