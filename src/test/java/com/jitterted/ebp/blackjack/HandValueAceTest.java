package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

  @Test
  public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
    Game game = new Game();
    var hand = List.of(new Card(Suit.get("whocares"), "A"),
                       new Card(Suit.get("whocares"), "5"));

    assertThat(game.handValueOf(hand))
        .isEqualTo(11 + 5);
  }

  @Test
  public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
    Game game = new Game();
    var hand = List.of(new Card(Suit.get("whocares"), "A"),
                       new Card(Suit.get("whocares"), "8"),
                       new Card(Suit.get("whocares"), "3"));

    assertThat(game.handValueOf(hand))
        .isEqualTo(1 + 8 + 3);
  }

}
