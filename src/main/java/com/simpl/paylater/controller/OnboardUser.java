
package com.simpl.paylater.controller;

import com.simpl.paylater.dto.UserOnboardRequest;
import com.simpl.paylater.exception.InvalidRequestException;
import com.simpl.paylater.pojo.Arguments;
import com.simpl.paylater.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("OnboardUser")
public class OnboardUser implements Command {

  @Autowired
  private UserService userService;

  @Override
  public String execute(Arguments arguments) {
    UserOnboardRequest userOnboardRequest = UserOnboardRequest.build(arguments.getArgument());
    userService.onboardNewUser(userOnboardRequest);
    return userOnboardRequest.getName() + "(" + userOnboardRequest.getCreditLimit() + ")";
  }

  @Override
  public void validateRequest(Arguments arguments) {
    if (arguments.getArgument().size() != 5) {
      throw new InvalidRequestException("Invalid OnboardUser request , check passed arguments");
    }
  }

}
