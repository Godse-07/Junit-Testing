package com.example.JunitTesting1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JavaUtilTest {

    JavaUtils ju = new JavaUtils();

    @Test
    void checkEvenTest() {
        assertTrue(ju.checkEven(20));
        assertFalse(ju.checkEven(3));
    }
}
