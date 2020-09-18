package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

  @Test
  public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
    Game game = new Game(new Random());
    var hand = List.of(new Card("whocares", "A"),
                       new Card("whocares", "5"));

    assertThat(new Hand(hand).handValueOf())
        .isEqualTo(11 + 5);
  }

  @Test
  public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
    Game game = new Game(new Random());
    var hand = List.of(new Card("whocares", "A"),
                       new Card("whocares", "8"),
                       new Card("whocares", "3"));

    assertThat(new Hand(hand).handValueOf())
        .isEqualTo(1 + 8 + 3);
  }

}
