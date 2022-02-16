
package com.simpl.paylater.controller;

import com.simpl.paylater.exception.InvalidRequestException;
import com.simpl.paylater.model.User;
import com.simpl.paylater.pojo.Arguments;
import com.simpl.paylater.service.report.ReportService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("ReportUsersAtCreditLimit")
public class ReportUsersAtCreditLimit implements Command {

  @Autowired
  private ReportService reportService;

  @Override
  public String execute(Arguments arguments) {
    List<User> users = reportService.userAtCreditLimit();
    if (users != null) {
      StringBuilder stringBuilder = new StringBuilder();
      for (User user : users) {
        stringBuilder.append("\n").append(user.getName());
      }
      return stringBuilder.toString();
    }
    return null;
  }

  @Override
  public void validateRequest(Arguments arguments) {
    if (arguments.getArgument().size() != 2) {
      throw new InvalidRequestException("Invalid report request , check passed arguments");
    }
  }
}
