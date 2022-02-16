
package com.simpl.paylater.utils;

import com.simpl.paylater.exception.PayLaterException;
import com.simpl.paylater.model.User;
import com.simpl.paylater.repository.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserUtilService {

  @Autowired
  private UserRepository userRepository;

  public User getUserByName(String name) {
    Optional<User> user = userRepository.findById(name);
    return user.orElse(null);
  }

  public User checkUserExist(String name) {
    User userByName = getUserByName(name);
    if (userByName == null) {
      throw new PayLaterException("User doesn't exist");
    }
    return userByName;
  }

  public User persistUser(User user) {
    return userRepository.save(user);
  }

  public User updateOutstanding(User user, double txnAmount) {
    user.setOutstandingBalance(user.getOutstandingBalance() + txnAmount);
    return persistUser(user);
  }
}
