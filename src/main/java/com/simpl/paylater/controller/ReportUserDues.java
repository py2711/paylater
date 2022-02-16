
package com.simpl.paylater.controller;

import com.simpl.paylater.dto.ReportUserDuesRequest;
import com.simpl.paylater.exception.InvalidRequestException;
import com.simpl.paylater.pojo.Arguments;
import com.simpl.paylater.service.report.ReportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("ReportUserDues")
public class ReportUserDues implements Command {

  @Autowired
  private ReportService reportService;

  @Override
  public String execute(Arguments arguments) {
    ReportUserDuesRequest request = new ReportUserDuesRequest(arguments.getArgument().get(2));
    return request.getUser() + "(dues : " + reportService.userDues(request) + ")";
  }

  @Override
  public void validateRequest(Arguments arguments) {
    if (arguments.getArgument().size() != 3) {
      throw new InvalidRequestException("Invalid report request , check passed arguments");
    }
  }
}
