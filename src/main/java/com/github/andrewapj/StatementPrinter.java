package com.github.andrewapj;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StatementPrinter {

    private static final String HEADER = "Date     |     Amount     |     Balance";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String COLUMN_SPACING = "   ";

    String print(List<Transaction> transactions) {

        StringBuilder builder = new StringBuilder();

        builder.append(HEADER);

        int balance = 0;
        List<String> lines = new ArrayList<>();
        transactions.sort(new TransactionDateComparator());
        for (Transaction transaction : transactions) {
            lines.add(buildStatementLine(transaction, balance));
            lines.add(NEW_LINE);
            balance += transaction.getAmount().getValue();
        }

        Collections.reverse(lines);
        lines.forEach(builder::append);

        return builder.toString();

    }

    private String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    private String buildStatementLine(final Transaction transaction, final int previousBalance){
        return formatDate(
            transaction.getDate()) +
            COLUMN_SPACING +
            transaction.getAmount().toString() +
            COLUMN_SPACING +
            Integer.toString(previousBalance + transaction.getAmount().getValue());
    }
}
