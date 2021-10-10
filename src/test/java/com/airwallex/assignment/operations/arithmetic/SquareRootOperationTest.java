package com.airwallex.assignment.operations.arithmetic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for {@link SquareRootOperation} class
 */
class SquareRootOperationTest {

    private BaseArithmeticOperation squareRootOperation;

    @BeforeEach
    public void init() {
        squareRootOperation = new SquareRootOperation();
    }

    @ParameterizedTest(name = "returns {1} when the input is {0} ")
    @CsvSource({
            "225, 15",
            "0, 0",
            "1, 1",
            "13, 3.605551275463989293119221267470496",
            "0.000001, 0.001",
    })
    void apply_extractSquareRootSuccessfully(BigDecimal input, BigDecimal result) {
        assertEquals(result, squareRootOperation.apply(input, null));
    }

    @Test
    void apply_failsToExtractSquareRoot() {
        BigDecimal input = new BigDecimal(-3);

        assertThrows(ArithmeticException.class, () -> squareRootOperation.apply(input, null));
    }
}