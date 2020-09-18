package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class DeckTest {

  // Z O M B I E S

  @Test
  public void fullDeckHas52Cards() throws Exception {
    Deck deck = new Deck(new Random());

    assertThat(deck.size())
        .isEqualTo(52);
  }

  @Test
  public void drawCardFromDeckReducesDeckSizeByOne() throws Exception {
    Deck deck = new Deck(new Random());

    deck.draw();

    assertThat(deck.size())
        .isEqualTo(51);
  }

  @Test
  public void drawCardFromDeckReturnsValidCard() throws Exception {
    Deck deck = new Deck(new Random());

    Card card = deck.draw();

    assertThat(card)
        .isNotNull();

    assertThat(card.rankValue())
        .isGreaterThan(0);
  }

  @Test
  public void drawAllCardsResultsInSetOf52UniqueCards() throws Exception {
    Deck deck = new Deck(new Random());

    Set<Card> drawnCards = new HashSet<>();
    for (int i = 1; i <= 52; i++) {
      drawnCards.add(deck.draw());
    }

    assertThat(drawnCards)
        .hasSize(52);
  }

}
