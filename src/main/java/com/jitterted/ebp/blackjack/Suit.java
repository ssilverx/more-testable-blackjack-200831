package com.jitterted.ebp.blackjack;

public enum Suit {
    PIKE("♠"), DIAMOND("♦"), HEART("♥"), CLOVER("♣");
    private String value;

    boolean isRed() {
        return "♥".equals(value) || "♦".contains(value);
    }
    
    Suit(String value) {
        this.value = value;
    }
}
