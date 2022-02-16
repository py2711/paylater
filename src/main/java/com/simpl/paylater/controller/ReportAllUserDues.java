
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
@Qualifier("ReportAllUserDues")
public class ReportAllUserDues implements Command {

  @Autowired
  private ReportService reportService;

  @Override
  public String execute(Arguments arguments) {
    List<User> users = reportService.allUserDues();
    if (users != null) {
      double totalDues = 0;
      StringBuilder stringBuilder = new StringBuilder();
      for (User user : users) {
        totalDues += user.getOutstandingBalance();
        stringBuilder.append("\n").append(user.getName()).append(" : ").append(user.getOutstandingBalance());
      }
      stringBuilder.append("\n").append("total : ").append(totalDues);
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
