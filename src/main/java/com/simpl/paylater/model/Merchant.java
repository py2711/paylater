
package com.simpl.paylater.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "merchant")
public class Merchant {

  /*
   * Merchant name
   */
  @Id
  @Column(name = "name")
  private String name;

  /*
   * Merchant email
   */
  @Column(name = "email")
  private String email;

  /*
   * Store discount percent provided by merchant
   */
  @Column(name = "discount_percent")
  private float discountPercent;

  /*
   * Store amount of discount provided by the merchant
   */
  @Column(name = "discount_provided")
  private double discountProvided;

  /*
   * Merchant on-boarding time
   */
  @Column(name = "onboard_on")
  private Timestamp onboardOn;

  public Merchant(String email, String name, float discountPercent) {
    this.email = email;
    this.name = name;
    this.discountPercent = discountPercent;
  }

  public Merchant() {
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getDiscountPercent() {
    return discountPercent;
  }

  public void setDiscountPercent(float discountPercent) {
    this.discountPercent = discountPercent;
  }

  public double getDiscountProvided() {
    return discountProvided;
  }

  public void setDiscountProvided(double discountProvided) {
    this.discountProvided = discountProvided;
  }

  public Timestamp getOnboardOn() {
    return onboardOn;
  }

  public void setOnboardOn(Timestamp onboardOn) {
    this.onboardOn = onboardOn;
  }

  @Override
  public String toString() {
    return "Merchant{" + "email='" + email + '\'' + ", name='" + name + '\'' + ", discountPercent=" + discountPercent
        + ", discount_provided=" + discountProvided + ", onboardOn=" + onboardOn + '}';
  }

}
