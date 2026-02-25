package com.TestAssignment1.Assignment1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class NumberUtilsTest {

    private final NumberUtils nu = new NumberUtils();

    // 1. Test isPositive using @ValueSource
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 100})
    void shouldReturnTrueForPositiveNumbers(int num) {
        assertTrue(nu.isPositive(num));
    }

    // Optional (better coverage)
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -10})
    void shouldReturnFalseForZeroAndNegativeNumbers(int num) {
        assertFalse(nu.isPositive(num));
    }

    // 2. Test square using @CsvSource
    @ParameterizedTest
    @CsvSource({
            "2, 4",
            "3, 9",
            "4, 16",
            "-2, 4"
    })
    void shouldReturnCorrectSquare(int input, int expected) {
        assertEquals(expected, nu.square(input));
    }

    // 3. Test using @MethodSource (at least 3 dynamic cases)
    @ParameterizedTest
    @MethodSource("provideNumbersForIsPositive")
    void shouldReturnTrueUsingMethodSource(int num) {
        assertTrue(nu.isPositive(num));
    }

    static Stream<Integer> provideNumbersForIsPositive() {
        return Stream.of(5, 10, 50);
    }
}
