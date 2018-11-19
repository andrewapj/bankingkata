package com.github.andrewapj;

import java.util.ArrayList;
import java.util.List;

class TransactionRepository {

    private final List<Transaction> transactions = new ArrayList<>();

    void add(Transaction transaction) {
        transactions.add(transaction);
    }

    List<Transaction> getTransactions() {
        return transactions;
    }
}
