package com.airwallex.assignment.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {

    @ParameterizedTest(name = "returns {1} when string is {0}")
    @CsvSource({
            "0, true",
            "0.0, true",
            "0f, true",
            "0ff, false",
            "35, true",
            "35.0000, true",
            "-35.0000, true",
            "-35.0f000, false",
            "ed, false",
    })
    void isNumber(String number, boolean expectedResult) {
        assertEquals(Utils.isNumber(number), expectedResult);
    }
}