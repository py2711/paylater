package com.simpl.paylater;

import com.simpl.paylater.controller.Command;
import com.simpl.paylater.exception.PayLaterException;
import com.simpl.paylater.pojo.Arguments;
import com.simpl.paylater.utils.CommandFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Entry point of Pay-later application
 */
@SpringBootApplication(scanBasePackages = { "com.simpl.paylater" })
@EnableJpaRepositories("com.simpl.paylater.repository")
public class PayLaterApplication implements CommandLineRunner {

  private static Logger LOG = LoggerFactory.getLogger(PayLaterApplication.class);

  @Autowired
  private CommandFactory commandFactory;

  public static void main(String[] args) {
    LOG.info("Starting Pay Later Service");
    SpringApplication.run(PayLaterApplication.class, args);
    LOG.info("Stopping Pay Later Service");
  }

  @Override
  public void run(String... args) throws IllegalArgumentException {
    /*
     * Check for empty argument
     */
    if (args.length < 2) {
      throw new IllegalArgumentException("Invalid request, Arguments are not complete");
    }

    Arguments arguments = new Arguments(args);
    LOG.info("EXECUTING : command line runner");
    LOG.info("Request Received : " + arguments);

    /*
     * Get command
     */
    LOG.info("Executing Command(RAW) : " + arguments);
    Object result;
    try {
      Command command = commandFactory.getCommandInstance(arguments);
      /*
       * Validate Request
       */
      command.validateRequest(arguments);

      /*
       * Execute command
       */
      result = command.execute(arguments);
    } catch (PayLaterException payLaterException) {
      result = payLaterException.getMessage();
    } catch (Exception e) {
      e.printStackTrace();
      result = "Something went wrong";
    }
    LOG.info("Command Executed ");
    LOG.info("RESPONSE  : " + result);

    /*
     * Call Service class will be responsible for redirecting request to appropriate method
     */
  }
}
