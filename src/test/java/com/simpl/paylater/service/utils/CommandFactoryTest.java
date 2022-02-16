
package com.simpl.paylater.service.utils;

import static org.junit.Assert.assertThrows;

import com.simpl.paylater.exception.UnknownCommandException;
import com.simpl.paylater.pojo.Arguments;
import com.simpl.paylater.utils.CommandFactory;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CommandFactoryTest {

  private CommandFactory commandFactory;

  @BeforeEach
  public void setUp() {
    commandFactory = new CommandFactory();
  }

  @AfterEach
  public void tearDown() {
  }

  @Test
  public void InvalidCommandTest() {
    String args[] = new String[1];
    args[0] = "test";
    Arguments arguments = new Arguments(args);
    assertThrows(UnknownCommandException.class, () -> commandFactory.getCommandInstance(arguments));
  }

  @Test
  public void InvalidSubCommandTest() {
    String args[] = new String[2];
    args[0] = "new";
    args[1] = "txn1";
    Arguments arguments = new Arguments(args);
    assertThrows(UnknownCommandException.class, () -> commandFactory.getCommandInstance(arguments));
  }

}
