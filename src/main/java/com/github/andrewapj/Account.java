package com.github.andrewapj;

import java.time.LocalDate;

class Account {

    private final TransactionRepository repository;
    private final StatementPrinter printer;

    public Account(TransactionRepository repository, StatementPrinter printer) {
        this.repository = repository;
        this.printer = printer;
    }

    void deposit(final int amount) {
        repository.add(new Transaction(LocalDate.now(), new Amount(amount)));
    }

    void withdraw(final int amount) {
        repository.add(new Transaction(LocalDate.now(), new Amount(-amount)));
    }

    void printStatement() {
        printer.print(new Statement().build(repository.getTransactions()));
    }
}
