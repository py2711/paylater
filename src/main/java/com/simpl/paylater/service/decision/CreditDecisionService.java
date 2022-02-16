
package com.simpl.paylater.service.decision;

import com.simpl.paylater.model.User;
import com.simpl.paylater.pojo.CreditDecisionEnum;

import org.springframework.stereotype.Service;

/**
 * Class representing logic behind credit decision
 */
@Service
public interface CreditDecisionService {

  CreditDecisionEnum getCreditDecision(User user, double amount);
}
