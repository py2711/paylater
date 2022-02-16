package com.simpl.paylater.service.transaction;

import com.simpl.paylater.dto.NewTxnRequest;
import com.simpl.paylater.model.Transaction;

import org.springframework.stereotype.Service;

@Service
public interface TransactionService {

  Transaction processTxn(NewTxnRequest request);
}
