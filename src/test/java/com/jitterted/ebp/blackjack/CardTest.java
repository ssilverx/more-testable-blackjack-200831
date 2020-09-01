package com.jitterted.ebp.blackjack;

import com.github.larseckart.tcr.TestCommitRevertMainExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.*;
import static org.fusesource.jansi.Ansi.ansi;

@ExtendWith(TestCommitRevertMainExtension.class)
class CardTest {

  @Test
  public void withNumberCardHasNumericValueOfTheNumber() throws Exception {
    Card card = new Card(Suit.get("don't care"), "7");

    assertThat(card.rankValue())
        .isEqualTo(7);
  }

  @Test
  public void withValueOfQueenHasNumericValueOf10() throws Exception {
    Card card = new Card(Suit.get("X"), "Q");

    assertThat(card.rankValue())
        .isEqualTo(10);
  }

  @Test
  public void withAceHasNumericValueOf1() throws Exception {
    Card card = new Card(Suit.get("don't care"), "A");

    assertThat(card.rankValue())
        .isEqualTo(1);
  }

  @Test
  public void suitOfHeartsOrDiamondsIsDisplayedInRed() throws Exception {
    // given a card with Hearts or Diamonds
    Card heartsCard = new Card(Suit.get("♥"), "10");
    Card diamondsCard = new Card(Suit.get("♦"), "8");

    // when we ask for its display representation
    String ansiRedString = ansi().fgRed().toString();

    // then we expect a red color ansi sequence
    assertThat(heartsCard.display())
        .contains(ansiRedString);
    assertThat(diamondsCard.display())
        .contains(ansiRedString);
  }

}
