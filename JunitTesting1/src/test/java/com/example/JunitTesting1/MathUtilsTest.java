package com.example.JunitTesting1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MathUtilsTest {
    MathUtils mu = new MathUtils();

    @ParameterizedTest
    //👉 Runs the same test multiple times
    //👉 Each time with different input values
    @ValueSource(ints = {1, 2, 0, 4, 0, 6, 7, 8, 9, 10})
    // Run this test 10 times
    // Each time passing one value to num.
    void testCheckIfGreaterThanZero(int num) {
        assertTrue(mu.checkIfGreaterThanZero(num));
    }
}
