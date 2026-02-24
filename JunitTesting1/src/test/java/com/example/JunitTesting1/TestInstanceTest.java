package com.example.JunitTesting1;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

/*
@TestInstance(Lifecycle.PER_CLASS) makes JUnit create only one instance of the test class for all test methods.
By default (PER_METHOD), JUnit creates a new instance for each test method.
PER_CLASS allows shared state and non-static @BeforeAll methods.
*/

public class TestInstanceTest {

    public TestInstanceTest() {
        System.out.println("HI");
    }

    private static RandomGenerator rg = new RandomGenerator();

    JavaUtils ju = new JavaUtils();

    @Test
    void checkEvenTest() {
        assertTrue(ju.checkEven(20));
        assertFalse(ju.checkEven(3));
    }

    @RepeatedTest(10)
    public void randomNumberTest() {
        int randomNumber = rg.generator();
//        assert randomNumber >= 0 && randomNumber < 10 : "Random number is out of range: " + randomNumber;
        assertTrue(randomNumber >= 0 && randomNumber < 10, "Random number is out of range: " + randomNumber);
    }
}
