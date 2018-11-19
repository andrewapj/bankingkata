package com.github.andrewapj;

import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TransactionTest {

    @Test
    void shouldCreateTransaction() {

        Transaction t = new Transaction(LocalDate.of(2015, Month.DECEMBER, 24), new Amount(500));

        Assertions.assertEquals(t.getDate(), LocalDate.of(2015, Month.DECEMBER, 24));
        Assertions.assertEquals(t.getAmount(), new Amount(500));
    }
}