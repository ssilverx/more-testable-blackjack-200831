package com.jitterted.ebp.blackjack;

import java.util.Objects;

class Rank {

    private final String value;

    private Rank(String value) {
        this.value = value;
    }

    public static Rank of(String value) {
        return new Rank(value);
    }

    public String getValue() {
        return value;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Rank rank = (Rank) o;
        return Objects.equals(value, rank.value);
    }

    @Override public int hashCode() {
        return Objects.hash(value);
    }
}
