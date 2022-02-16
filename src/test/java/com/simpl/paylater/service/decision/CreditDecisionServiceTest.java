
package com.simpl.paylater.service.decision;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.simpl.paylater.model.User;
import com.simpl.paylater.pojo.CreditDecisionEnum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreditDecisionServiceTest {

  private CreditDecisionService creditDecisionService;

  private User user;

  @BeforeEach
  public void setUp() {
    creditDecisionService = new CreditDecisionServiceImpl();
    user = new User("testUser", "testUser@users.com", 10);
  }

  @AfterEach
  public void tearDown() {
    user = null;
  }

  @Test
  public void shouldAcceptTransaction() {
    double amount = 9;
    CreditDecisionEnum creditDecision = creditDecisionService.getCreditDecision(user, amount);
    assertThat(creditDecision.isAccepted(), is(true));
    assertThat(creditDecision.getMessage(), is("success!"));
  }

  @Test
  public void shouldRejectTransaction() {
    double amount = 11;
    CreditDecisionEnum creditDecision = creditDecisionService.getCreditDecision(user, amount);
    assertThat(creditDecision.isAccepted(), is(false));
    assertThat(creditDecision.getMessage(), is("rejected! (reason: credit limit)"));
  }

}
