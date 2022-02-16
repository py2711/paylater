package com.simpl.paylater.pojo;

import com.simpl.paylater.exception.UnknownCommandException;

public enum CommandNewEnum {

  USER("user"),
  MERCHANT("merchant"),
  TXN("txn");

  private String name;

  CommandNewEnum(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public static CommandNewEnum fromName(String name) {
    switch (name) {
      case "user":
        return USER;
      case "merchant":
        return MERCHANT;
      case "txn":
        return TXN;
    }
    throw new UnknownCommandException(String.format("Invalid [new] command : %s ", name));
  }
}
