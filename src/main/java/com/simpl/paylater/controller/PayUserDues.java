
package com.simpl.paylater.controller;

import com.simpl.paylater.dto.PaybackUserDuesRequest;
import com.simpl.paylater.exception.InvalidRequestException;
import com.simpl.paylater.model.User;
import com.simpl.paylater.pojo.Arguments;
import com.simpl.paylater.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("PayUserDues")
public class PayUserDues implements Command {

  @Autowired
  private UserService userService;

  @Override
  public String execute(Arguments arguments) {
    PaybackUserDuesRequest request = PaybackUserDuesRequest.build(arguments.getArgument());
    User user = userService.paybackDues(request);
    return request.getUser() + "(dues : " + user.getOutstandingBalance() + ")";
  }

  @Override
  public void validateRequest(Arguments arguments) {
    if (arguments.getArgument().size() != 3) {
      throw new InvalidRequestException("Invalid pay user dues request , check passed arguments");
    }
  }
}
