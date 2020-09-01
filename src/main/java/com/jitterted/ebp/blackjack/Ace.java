package com.jitterted.ebp.blackjack;

class Ace extends Rank {

    public Ace(String value) {
        super(value);
    }

    @Override
    int value() {
        return 1;
    }
}
