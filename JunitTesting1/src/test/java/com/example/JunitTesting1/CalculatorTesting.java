package com.example.JunitTesting1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTesting {
    private static Calculator cal = new Calculator();

    @Test
    public void testAdd() {
        assert cal.add(2, 3) == 5;
    }

    @Test
    public void testAdd1() {
        assertEquals(5, cal.add(2, 3));
    }

    @Test
    public void testSubtract() {
        assert cal.subtract(5, 2) == 3;
    }

    @Test
    public void testMultiply() {
        assert cal.multiply(4, 3) == 12;
    }

    @Test
    public void testDivide() {
        assert cal.divide(10, 2) == 5.0;
    }
}
