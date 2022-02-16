
package com.simpl.paylater.controller;

import com.simpl.paylater.dto.UpdateUserCreditRequest;
import com.simpl.paylater.exception.InvalidRequestException;
import com.simpl.paylater.pojo.Arguments;
import com.simpl.paylater.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("UpdateUserCreditLimit")
public class UpdateUserCreditLimit implements Command {

  @Autowired
  private UserService userService;

  @Override
  public String execute(Arguments arguments) {
    UpdateUserCreditRequest request =
        new UpdateUserCreditRequest(arguments.getArgument().get(2), Double.parseDouble(arguments.getArgument().get(3)));
    userService.updateCreditLimit(request);
    return request.getUser() + "(" + request.getAmount() + ")";
  }

  @Override
  public void validateRequest(Arguments arguments) {
    if (arguments.getArgument().size() != 4) {
      throw new InvalidRequestException("Invalid update user limit request , check passed arguments");
    }
  }
}
