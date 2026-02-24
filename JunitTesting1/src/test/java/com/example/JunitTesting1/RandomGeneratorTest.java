package com.example.JunitTesting1;

import org.junit.jupiter.api.RepeatedTest;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomGeneratorTest {
    private static RandomGenerator rg = new RandomGenerator();

    @RepeatedTest(10)
    public void randomNumberTest() {
        int randomNumber = rg.generator();
//        assert randomNumber >= 0 && randomNumber < 10 : "Random number is out of range: " + randomNumber;
        assertTrue(randomNumber >= 0 && randomNumber < 10, "Random number is out of range: " + randomNumber);
    }
}
