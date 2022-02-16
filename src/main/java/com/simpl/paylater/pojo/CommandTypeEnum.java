package com.simpl.paylater.pojo;

import com.simpl.paylater.exception.UnknownCommandException;

public enum CommandTypeEnum {
  NEW("new"),
  UPDATE("update"),
  PAYBACK("payback"),
  REPORT("report");

  private String name;

  CommandTypeEnum(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public static CommandTypeEnum fromName(String name) {
    switch (name) {
      case "new":
        return NEW;
      case "update":
        return UPDATE;
      case "payback":
        return PAYBACK;
      case "report":
        return REPORT;
    }
    throw new UnknownCommandException(String.format("Invalid Command : %s ", name));
  }
}
