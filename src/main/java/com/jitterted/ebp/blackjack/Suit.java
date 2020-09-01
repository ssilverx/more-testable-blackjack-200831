package com.jitterted.ebp.blackjack;

import java.util.HashMap;
import java.util.Map;

public enum Suit {
    PIKE("♠"), DIAMOND("♦"), HEART("♥"), CLOVER("♣");
    private String value;

    boolean isRed() {
      return "♥♦".contains(getValue());
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
