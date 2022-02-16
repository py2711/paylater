package com.simpl.paylater.controller;

import com.simpl.paylater.pojo.Arguments;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public interface Command {

  public Object execute(Arguments arguments);

  public void validateRequest(Arguments arguments);

}
