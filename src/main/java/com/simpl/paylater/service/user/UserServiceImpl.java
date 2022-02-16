
package com.simpl.paylater.service.user;

import com.simpl.paylater.dto.PaybackUserDuesRequest;
import com.simpl.paylater.dto.UpdateUserCreditRequest;
import com.simpl.paylater.dto.UserOnboardRequest;
import com.simpl.paylater.exception.PayLaterException;
import com.simpl.paylater.model.User;
import com.simpl.paylater.utils.UserUtilService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Configurable
public class UserServiceImpl implements UserService {

  @Autowired
  UserUtilService userUtilService;

  @Override
  public User onboardNewUser(UserOnboardRequest request) {
    validateOnboardingRequest(request);
    User user = new User(request.getName(), request.getEmail(), request.getCreditLimit());
    if (userUtilService.getUserByName(user.getName()) != null) {
      throw new PayLaterException("rejected! (reason: user already exists)");
    }
    User insertUser;
    try {
      insertUser = userUtilService.persistUser(user);
    } catch (DataIntegrityViolationException e) {
      throw new PayLaterException("rejected! (reason: user already exists)");
    }
    return insertUser;
  }

  @Override
  public User updateCreditLimit(UpdateUserCreditRequest request) {
    validateCreditUpdateRequest(request);
    User user = userUtilService.getUserByName(request.getUser());
    if (user == null) {
      throw new PayLaterException("rejected! (reason: user doesn't exists)");
    }
    user.setCreditLimit(request.getAmount());
    user = userUtilService.persistUser(user);
    return user;
  }

  @Override
  public User paybackDues(PaybackUserDuesRequest request) {
    User user = userUtilService.getUserByName(request.getUser());
    if (user == null) {
      throw new PayLaterException("rejected! (reason: user doesn't exists)");
    }
    user.setOutstandingBalance(user.getOutstandingBalance() - request.getAmount());
    user = userUtilService.persistUser(user);
    return user;
  }

  private void validateOnboardingRequest(UserOnboardRequest request) {
    if (!StringUtils.hasLength(request.getEmail()) || !StringUtils.hasLength(request.getName())
        || request.getCreditLimit() <= 0) {
      throw new PayLaterException("Invalid on board user request. Kindly verify the request");
    }
  }

  private void validateCreditUpdateRequest(UpdateUserCreditRequest request) {
    if (!StringUtils.hasLength(request.getUser()) || request.getAmount() <= 0) {
      throw new PayLaterException("Invalid user credit update request. Kindly verify the request");
    }
  }

}
