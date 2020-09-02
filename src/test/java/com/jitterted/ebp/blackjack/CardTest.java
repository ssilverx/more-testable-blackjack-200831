package com.jitterted.ebp.blackjack;

import com.github.larseckart.tcr.TestCommitRevertMainExtension;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.*;
import static org.fusesource.jansi.Ansi.ansi;

@ExtendWith(TestCommitRevertMainExtension.class)
class CardTest {

  @Test
  public void withNumberCardHasNumericValueOfTheNumber() throws Exception {
    Card card = new Card(Suit.DIAMOND, Rank.of("7"));

    assertThat(card.rankValue())
        .isEqualTo(7);
  }

  @Test
  public void withValueOfQueenHasNumericValueOf10() throws Exception {
    Card card = new Card(Suit.DIAMOND, Rank.of("Q"));

    assertThat(card.rankValue())
        .isEqualTo(10);
  }

  @Test
  public void withAceHasNumericValueOf1() throws Exception {
    Card card = new Card(Suit.DIAMOND, Rank.of("A"));

    assertThat(card.rankValue())
        .isEqualTo(1);
  }

  @Test
  public void suitOfHeartsOrDiamondsIsDisplayedInRed() throws Exception {
    // given a card with Hearts or Diamonds
    Card heartsCard = new Card(Suit.HEART, Rank.of("10"));
    Card diamondsCard = new Card(Suit.DIAMOND, Rank.of("8"));

    // when we ask for its display representation
    String ansiRedString = ansi().fgRed().toString();

    // then we expect a red color ansi sequence
    assertThat(heartsCard.display())
        .contains(ansiRedString);
    assertThat(diamondsCard.display())
        .contains(ansiRedString);
  }

  @Test
  void card_display() throws Exception {
    Card card = new Card(Suit.HEART, Rank.of("10"));
    Approvals.verify(card.display());
  }

  @Test
  void card_display_2() throws Exception {
    Card card = new Card(Suit.HEART, Rank.of("J"));
    Approvals.verify(card.display());
  }

}
