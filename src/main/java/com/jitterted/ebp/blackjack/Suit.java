package com.jitterted.ebp.blackjack;

public enum Suit {
    PIKE("♠"), DIAMOND("♦"), HEART("♥"), CLOVER("♣");
    private String value;

    boolean isRed() {
        return "♥♦".contains(value);
    }

    Suit(String value) {
        this.value = value;
    }
}
