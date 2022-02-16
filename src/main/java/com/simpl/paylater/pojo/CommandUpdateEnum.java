package com.simpl.paylater.pojo;

import com.simpl.paylater.exception.UnknownCommandException;

public enum CommandUpdateEnum {

  USER("user"),
  MERCHANT("merchant");

  private String name;

  CommandUpdateEnum(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public static CommandUpdateEnum fromName(String name) {
    switch (name) {
      case "user":
        return USER;
      case "merchant":
        return MERCHANT;
    }
    throw new UnknownCommandException(String.format("Invalid [update] command  : %s ", name));
  }
}
