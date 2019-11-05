package com.github.andrewapj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class StatementTest {

    private static final String TEST_HEADER = "Date     |     Amount     |     Balance";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String COLUMN_SPACING = "   ";

    @Test
    void shouldPrintStatementHeader() {
        Statement statement = new Statement();
        statement.build(Collections.emptyList());

        assertEquals(TEST_HEADER, statement.toString());
    }

    @Test
    void shouldPrintFullStatementWithTransactions() {
        Statement builtStatement = new Statement().build(
            Stream.of(
                new Transaction(LocalDate.of(2016, Month.AUGUST, 23), new Amount(-100)),
                new Transaction(LocalDate.of(2015, Month.DECEMBER, 24), new Amount(500)))
                .collect(Collectors.toList())
        );

        assertEquals(
            TEST_HEADER +
                NEW_LINE +
                "23.08.2016" + COLUMN_SPACING + "-100" + COLUMN_SPACING + "400" +
                NEW_LINE +
                "24.12.2015" + COLUMN_SPACING + "+500" + COLUMN_SPACING + "500",
            builtStatement.toString());
    }
}
