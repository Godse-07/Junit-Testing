package com.example.JunitTesting1;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringUtilsTest {
    StringUtils str = new StringUtils();

    // one way to test the method is to write multiple test cases for different strings.
    @ParameterizedTest
    @ValueSource(strings = {"Pushan", "Mukhopadhyay", "Hello World", "JUnit Testing"})
    void checkGreaterThan6Test(String s) {
        assertTrue(str.checkGreaterThan6(s));
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void checkGreaterThan6Test2(String s) {
        assertTrue(str.checkGreaterThan6(s));
    }

    public static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of("P"),
                Arguments.of("Mukhop    adhyay"),
                Arguments.of("Hello World"),
                Arguments.of("JUnit Testing")
        );
    }

}
