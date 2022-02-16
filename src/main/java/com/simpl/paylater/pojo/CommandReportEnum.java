package com.simpl.paylater.pojo;

import com.simpl.paylater.exception.UnknownCommandException;

public enum CommandReportEnum {

  DISCOUNT("discount"),
  DUES("dues"),
  USERS_AT_CREDIT_RISK("users-at-credit-limit"),
  TOTAL_DUES("total-dues");

  private String name;

  CommandReportEnum(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public static CommandReportEnum fromName(String name) {
    switch (name) {
      case "discount":
        return DISCOUNT;
      case "dues":
        return DUES;
      case "users-at-credit-limit":
        return USERS_AT_CREDIT_RISK;
      case "total-dues":
        return TOTAL_DUES;
    }
    throw new UnknownCommandException(String.format("Invalid [report] command : %s ", name));
  }
}
