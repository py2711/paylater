
package com.simpl.paylater.utils;

import com.simpl.paylater.model.Transaction;
import com.simpl.paylater.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionUtilService {

  @Autowired
  private TransactionRepository transactionRepository;

  public Transaction persistTransaction(Transaction transaction) {
    return transactionRepository.save(transaction);
  }
}
