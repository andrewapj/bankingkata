package com.github.andrewapj;

class App {
    public static void main(String[] args) {
        Account account =
            new Account(new TransactionRepository(), new StatementPrinter());

        account.deposit(1000);
        account.withdraw(200);
        account.withdraw(200);

        account.printStatement();
    }
}
