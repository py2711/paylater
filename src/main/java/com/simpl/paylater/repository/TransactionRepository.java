
package com.simpl.paylater.repository;

import com.simpl.paylater.model.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Transaction dao.
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
