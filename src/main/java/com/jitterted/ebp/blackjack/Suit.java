package com.jitterted.ebp.blackjack;

import org.fusesource.jansi.Ansi;

import java.util.HashMap;
import java.util.Map;

public enum Suit {
    PIKE("♠"), DIAMOND("♦"), HEART("♥"), CLOVER("♣");
    private String value;

    Ansi.Color getCardColor() {
      return "♥♦".contains(getValue()) ? Ansi.Color.RED : Ansi.Color.BLACK;
    }

    public String getValue() {
        return value;
    }

    Suit(String value) {
        this.value = value;
    }

    private static final Map<String, Suit> lookup = new HashMap<>();

    static {
        for (Suit suit : Suit.values()) {
            lookup.put(suit.getValue(), suit);
        }
    }

    public static Suit get(String suit) {
        return lookup.getOrDefault(suit, Suit.CLOVER);
    }
}
