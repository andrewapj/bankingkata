package com.github.andrewapj;

import java.time.LocalDate;

final class Transaction {

    private final LocalDate date;
    private final Amount amount;

    Transaction(LocalDate date, Amount amount) {
        this.date = date;
        this.amount = amount;
    }

    LocalDate getDate() {
        return date;
    }

    public Amount getAmount() {
        return amount;
    }
}
