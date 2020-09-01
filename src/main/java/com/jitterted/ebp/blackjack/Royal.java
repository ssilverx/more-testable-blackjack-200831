package com.jitterted.ebp.blackjack;

class Royal extends Rank {

    public Royal(String value) {
        super(value);
    }

    @Override
    int value() {
        return 10;
    }
}
