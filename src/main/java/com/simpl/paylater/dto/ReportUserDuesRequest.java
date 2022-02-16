
package com.simpl.paylater.dto;

/**
 * Request class to report user dues
 */
public class ReportUserDuesRequest {

  private String user;

  public ReportUserDuesRequest(String user) {
    this.user = user;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "ReportUserDues{" + "user='" + user + '\'' + '}';
  }
}
