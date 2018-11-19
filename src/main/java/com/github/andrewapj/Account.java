package com.github.andrewapj;

import java.time.LocalDate;

class Account {

    private final TransactionRepository repository;
    private final StatementPrinter printer;
    private final Console console;

    public Account(TransactionRepository repository, StatementPrinter printer, Console console) {
        this.repository = repository;
        this.printer = printer;
        this.console = console;
    }

    void deposit(final int amount) {
        repository.add(new Transaction(LocalDate.now(), new Amount(amount)));
    }

    void withdraw(final int amount) {
        repository.add(new Transaction(LocalDate.now(), new Amount(-amount)));
    }

    void printStatement()
    {
        console.printToConsole(
            printer.print(repository.getTransactions()));
    }
}
