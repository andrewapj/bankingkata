package com.github.andrewapj;

import java.util.Objects;

public final class Amount {

    private final int amount;

    public Amount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        if (amount > 0) {
            return "+" + amount;
        }
        return Integer.toString(amount);
    }

    int getValue() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Amount)) {
            return false;
        }
        Amount amount1 = (Amount) o;
        return amount == amount1.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
