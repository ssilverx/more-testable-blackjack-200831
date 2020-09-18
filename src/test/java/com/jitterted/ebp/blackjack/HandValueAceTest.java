package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class HandValueAceTest {

  @Test
  public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
      final Hand applesauce = new Hand();
      applesauce.addCard(new Card("whocares", "5"));
      applesauce.addCard(new Card("whocares", "A"));
      assertThat(applesauce.handValueOf())
              .isEqualTo(11 + 5);
  }

  @Test
  public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
      final Hand applesauce = new Hand();
      applesauce.addCard(new Card("whocares", "A"));
      applesauce.addCard(new Card("whocares", "8"));
      applesauce.addCard(new Card("whocares", "3"));
      assertThat(applesauce.handValueOf())
              .isEqualTo(1 + 8 + 3);
  }

}
