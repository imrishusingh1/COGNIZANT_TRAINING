package com.example.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void shouldAddTwoNumbers() {
        int result = calculator.add(2, 3);

        assertEquals(5, result);
    }

    @Test
    void shouldCheckWhetherNumberIsEven() {
        boolean result = calculator.isEven(4);

        assertTrue(result);
    }
}
