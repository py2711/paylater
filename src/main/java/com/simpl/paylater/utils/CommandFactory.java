
package com.simpl.paylater.utils;

import com.simpl.paylater.controller.Command;
import com.simpl.paylater.exception.UnknownCommandException;
import com.simpl.paylater.pojo.Arguments;
import com.simpl.paylater.pojo.CommandNewEnum;
import com.simpl.paylater.pojo.CommandReportEnum;
import com.simpl.paylater.pojo.CommandTypeEnum;
import com.simpl.paylater.pojo.CommandUpdateEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Class to redirect commands to their respective services
 */
@Service
public class CommandFactory {

  @Autowired
  @Qualifier("OnboardUser")
  private Command onboardUser;

  @Autowired
  @Qualifier("ReportMerchantDiscount")
  private Command reportMerchantDiscount;

  @Autowired
  @Qualifier("OnboardMerchant")
  private Command onboardMerchant;

  @Autowired
  @Qualifier("PayUserDues")
  private Command payUserDues;

  @Autowired
  @Qualifier("ProcessTransaction")
  private Command processTransaction;

  @Autowired
  @Qualifier("ReportAllUserDues")
  private Command reportAllUserDues;

  @Autowired
  @Qualifier("ReportUserDues")
  private Command reportUserDues;

  @Autowired
  @Qualifier("ReportUsersAtCreditLimit")
  private Command reportUsersAtCreditLimit;

  @Autowired
  @Qualifier("UpdateMerchantDiscount")
  private Command updateMerchantDiscount;

  @Autowired
  @Qualifier("UpdateUserCreditLimit")
  private Command updateUserCreditLimit;

  public Command getCommandInstance(Arguments arguments) {
    CommandTypeEnum commandTypeEnum = CommandTypeEnum.fromName(arguments.getCommandType());
    switch (commandTypeEnum) {
      case NEW:
        return getNewCommandImplementation(arguments);
      case UPDATE:
        return getUpdateCommandImplementation(arguments);
      case PAYBACK:
        return getPaybackCommandImplementation(arguments);
      case REPORT:
        return getReportImplementation(arguments);
      default:
        throw new UnknownCommandException(String.format("Unknown Command : %s ", commandTypeEnum.getName()));
    }
  }

  private Command getNewCommandImplementation(Arguments arguments) {
    CommandNewEnum commandNewEnum = CommandNewEnum.fromName(arguments.getSubCommand());
    switch (commandNewEnum) {
      case USER:
        return onboardUser;
      case MERCHANT:
        return onboardMerchant;
      case TXN:
        return processTransaction;
      default:
        throw new UnknownCommandException(String.format("Invalid [new] command : %s ", commandNewEnum.getName()));
    }
  }

  private Command getUpdateCommandImplementation(Arguments arguments) {
    CommandUpdateEnum commandUpdateEnum = CommandUpdateEnum.fromName(arguments.getSubCommand());
    switch (commandUpdateEnum) {
      case USER:
        return updateUserCreditLimit;
      case MERCHANT:
        return updateMerchantDiscount;
      default:
        throw new UnknownCommandException(String.format("Invalid [update] command : %s ", commandUpdateEnum.getName()));
    }

  }

  private Command getPaybackCommandImplementation(Arguments arguments) {
    return payUserDues;
  }

  private Command getReportImplementation(Arguments arguments) {
    CommandReportEnum commandReportEnum = CommandReportEnum.fromName(arguments.getSubCommand());
    switch (commandReportEnum) {
      case DISCOUNT:
        return reportMerchantDiscount;
      case DUES:
        return reportUserDues;
      case USERS_AT_CREDIT_RISK:
        return reportUsersAtCreditLimit;
      case TOTAL_DUES:
        return reportAllUserDues;
      default:
        throw new UnknownCommandException(String.format("Invalid [report] command : %s ", commandReportEnum.getName()));
    }
  }
}
