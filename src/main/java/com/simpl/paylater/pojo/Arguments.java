
package com.simpl.paylater.pojo;

import java.util.Arrays;
import java.util.List;

public class Arguments {

  private List<String> argument;

  public Arguments(String[] argument) {
    this.argument = Arrays.asList(argument);
    ;
  }

  public List<String> getArgument() {
    return argument;
  }

  public void setArgument(List<String> argument) {
    this.argument = argument;
  }

  public String getCommandType() {
    return argument.get(0);
  }

  public String getSubCommand() {
    return argument.get(1);
  }

  @Override
  public String toString() {
    return "Arguments{" + "argument=" + argument + '}';
  }
}
