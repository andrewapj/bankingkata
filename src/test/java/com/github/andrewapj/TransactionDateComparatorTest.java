package com.github.andrewapj;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TransactionDateComparatorTest {

    @Test
    void shouldSortTransactionByDateWithOldestFirst() {

        List<Transaction> transactions = Stream.of(
            new Transaction(LocalDate.of(2015, Month.DECEMBER, 1), new Amount(200)),
            new Transaction(LocalDate.of(2014, Month.JANUARY, 1), new Amount(200)))
            .sorted(new TransactionDateComparator())
            .collect(Collectors.toList());

        Assertions.assertEquals(transactions.get(0).getDate(), LocalDate.of(2014, Month.JANUARY, 1));
    }

}