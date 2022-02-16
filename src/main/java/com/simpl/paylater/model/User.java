
package com.simpl.paylater.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class User {

  @Id
  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "credit_limit")
  private double creditLimit;

  @Column(name = "outstanding_balance")
  private double outstandingBalance;

  @Column(name = "onboard_on")
  private Timestamp onboardOn;

  public User(String name, String email, double creditLimit) {
    this.name = name;
    this.email = email;
    this.creditLimit = creditLimit;
  }

  public User() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public double getCreditLimit() {
    return creditLimit;
  }

  public void setCreditLimit(double creditLimit) {
    this.creditLimit = creditLimit;
  }

  public double getOutstandingBalance() {
    return outstandingBalance;
  }

  public void setOutstandingBalance(double outstandingBalance) {
    this.outstandingBalance = outstandingBalance;
  }

  public Timestamp getOnboardOn() {
    return onboardOn;
  }

  public void setOnboardOn(Timestamp onboardOn) {
    this.onboardOn = onboardOn;
  }

  @Override
  public String toString() {
    return "";
  }
}
