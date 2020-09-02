package com.jitterted.ebp.blackjack;

import java.util.Objects;

class Rank {

    private final String value;

    Rank(String value) {
        this.value = value;
    }

    public static Rank of(String value) {
        if ("JQK".contains(value)) {
            return new Royal(value);
        } else if (value.equals("A")) {
            return new Ace("A");
        } else {
            return new Rank(value);
        }
    }

    int value() {
        return Integer.parseInt(value);
    }

    @Override public String toString() {
        return "" + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Rank rank = (Rank) o;
        return Objects.equals(value, rank.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
