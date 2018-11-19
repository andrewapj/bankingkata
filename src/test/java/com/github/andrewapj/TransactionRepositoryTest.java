package com.github.andrewapj;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TransactionRepositoryTest {

    @Test
    void shouldAddATransaction() {
        TransactionRepository repository = new TransactionRepository();

        repository.add(new Transaction(LocalDate.now(), new Amount(200)));

        Assertions.assertTrue(repository.getTransactions().size() > 0);
    }
}