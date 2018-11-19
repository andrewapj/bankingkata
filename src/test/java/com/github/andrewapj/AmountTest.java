package com.github.andrewapj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AmountTest {

    @Test
    void shouldDisplayPositiveAmount() {
        Amount amount = new Amount(100);
        assertEquals("+100", amount.toString());
    }

    @Test
    void shouldDisplayNegativeAmount() {
        Amount amount = new Amount(-100);
        assertEquals("-100", amount.toString());
    }

    @Test
    void shouldDisplayZeroAmount() {
        Amount amount = new Amount(0);
        assertEquals("0", amount.toString());
    }

}