package com.jitterted.ebp.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.fusesource.jansi.Ansi.ansi;

public class Hand {

    private final List<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    void addCard(Card card) {
        hand.add(card);
    }

    String asString() {
        return hand.stream()
                   .map(Card::display)
                   .collect(Collectors.joining(
                           ansi().cursorUp(6).cursorRight(1).toString()));
    }

    Card first() {
        return hand.get(0);
    }

    public int handValueOf() {
        int handValue = hand
                             .stream()
                             .mapToInt(Card::rankValue)
                             .sum();

        // does the hand contain at least 1 Ace?
        boolean hasAce = hand
                              .stream()
                              .anyMatch(card -> card.rankValue() == 1);

        // if the total hand value <= 11, then count the Ace as 11 by adding 10
        if (hasAce && handValue < 11) {
            handValue += 10;
        }

        return handValue;
    }
}
