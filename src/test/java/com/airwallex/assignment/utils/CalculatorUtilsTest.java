package com.airwallex.assignment.utils;

import com.airwallex.assignment.exceptions.InsufficientNumberOfArgumentsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link com.airwallex.assignment.utils.CalculatorUtils} class
 */
class CalculatorUtilsTest {

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
        assertEquals(CalculatorUtils.isNumber(number), expectedResult);
    }

    @ParameterizedTest(name = "Does not fail when stack size is {0} and number of expected arguments is {1}")
    @CsvSource({
            "1, 0, *",
            "2, 1, +",
            "0, 0, +",
    })
    void validateStackSize_validatesSuccessfully(int stackSize, int expectedNumberOfArguments, String operation) {
        assertDoesNotThrow(() -> CalculatorUtils.validateStackSize(stackSize, expectedNumberOfArguments, operation));
    }

    @ParameterizedTest(name = "Fails when stack size is {0} and number of expected arguments is {1}")
    @CsvSource({
            "0, 1, *",
            "1, 2, +",
    })
    void validateStackSize_failsToValidate(int stackSize, int expectedNumberOfArguments, String operation) {
        assertThrows(InsufficientNumberOfArgumentsException.class,
                () -> CalculatorUtils.validateStackSize(stackSize, expectedNumberOfArguments, operation));
    }

    @Test
    void copyStack_assertSizeNotChangedAfterRemove() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.add(new BigDecimal(1));
        stack.add(new BigDecimal(2));

        Stack<BigDecimal> copy = CalculatorUtils.copyStack(stack);

        stack.pop();
        assertEquals(2, copy.size());
    }
}