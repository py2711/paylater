
package com.simpl.paylater.controller;

import com.simpl.paylater.dto.NewTxnRequest;
import com.simpl.paylater.exception.InvalidRequestException;
import com.simpl.paylater.model.Transaction;
import com.simpl.paylater.pojo.Arguments;
import com.simpl.paylater.service.transaction.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("ProcessTransaction")
public class ProcessTransaction implements Command {

  @Autowired
  private TransactionService transactionService;

  @Override
  public String execute(Arguments arguments) {
    NewTxnRequest newTxnRequest = NewTxnRequest.build(arguments.getArgument());
    Transaction transaction = transactionService.processTxn(newTxnRequest);
    return transaction.getDecision().getMessage();
  }

  @Override
  public void validateRequest(Arguments arguments) {
    if (arguments.getArgument().size() != 5) {
      throw new InvalidRequestException("Invalid new txn , check passed arguments");
    }
  }
}
