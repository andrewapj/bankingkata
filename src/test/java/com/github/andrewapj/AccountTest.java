package com.github.andrewapj;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class AccountTest {

    private Account account;
    private TransactionRepository repository;
    private @Mock TransactionRepository mockRepository;
    private @Mock StatementPrinter mockPrinter;
    private @Mock Console mockConsole;

    @BeforeEach
    void setup(){
        repository = new TransactionRepository();
        account = new Account(repository, mockPrinter, mockConsole);
    }

    @Test
    void shouldDeposit() {
        account.deposit(100);
        assertEquals(100, repository.getTransactions().get(0).getAmount().getValue());
    }

    @Test
    void shouldWithdraw(){
        account.withdraw(100);
        assertEquals(-100, repository.getTransactions().get(0).getAmount().getValue());
    }

    @Test
    void shouldPrintStatement()
    {
        Account accountWithMocks = new Account(mockRepository, mockPrinter, mockConsole);
        List<Transaction> transactionsInRepository =
            Stream.of(
                new Transaction(LocalDate.now(), new Amount(500)),
                new Transaction(LocalDate.now(), new Amount(250)))
                .collect(Collectors.toList());


        Mockito.when(mockRepository.getTransactions()).thenReturn(transactionsInRepository);

        accountWithMocks.printStatement();

        verify(mockPrinter).print(transactionsInRepository);
        verify(mockConsole, Mockito.times(1)).printToConsole(Mockito.any());
    }

}