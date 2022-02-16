
package com.simpl.paylater.service.decision;

import com.simpl.paylater.model.User;
import com.simpl.paylater.pojo.CreditDecisionEnum;

import org.springframework.stereotype.Service;

/**
 * Class representing logic behind credit decision
 */
@Service
public class CreditDecisionServiceImpl implements CreditDecisionService {
  /**
   * Function to decide whether transaction is allowed or not
   *
   * @param user
   * @param amount
   * @return
   */
  @Override
  public CreditDecisionEnum getCreditDecision(User user, double amount) {
    double newTotalOutstandingBalance = getNewOutstandingAmount(user.getOutstandingBalance(), amount);
    if (newTotalOutstandingBalance > user.getCreditLimit()) {
      return CreditDecisionEnum.CREDIT_LIMITED_BREACHED;
    }
    return CreditDecisionEnum.ACCEPTED;
  }

  private double getNewOutstandingAmount(double current, double txnAmount) {
    return current + txnAmount;
  }

}
