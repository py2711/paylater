
package com.simpl.paylater.service.user;

import com.simpl.paylater.dto.PaybackUserDuesRequest;
import com.simpl.paylater.dto.UpdateUserCreditRequest;
import com.simpl.paylater.dto.UserOnboardRequest;
import com.simpl.paylater.model.User;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

  User onboardNewUser(UserOnboardRequest request);

  User updateCreditLimit(UpdateUserCreditRequest request);

  User paybackDues(PaybackUserDuesRequest request);
}
