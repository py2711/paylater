
package com.simpl.paylater.repository;

import com.simpl.paylater.model.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * The interface User dao.
 */

@Repository
public interface UserRepository extends JpaRepository<User, String> {

  @Query("SELECT u FROM User u WHERE u.outstandingBalance >= u.creditLimit")
  Optional<List<User>> fetchUsersAtCreditLimit();

  @Query("SELECT u FROM User u WHERE u.outstandingBalance > 0")
  Optional<List<User>> fetchUsersHavingDues();
}
