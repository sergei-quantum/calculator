package com.airwallex.assignment.operations.arithmetic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link SubtractionOperation} class
 */
class SubtractionOperationTest {

    private BaseArithmeticOperation subtractionOperation;

    @BeforeEach
    public void init() {
        subtractionOperation = new SubtractionOperation();
    }

    @ParameterizedTest(name = "returns {2} when the first operand is {0} and the second operand is {1}")
    @CsvSource({
            "10, 10, 0",
            "10.00, 15.0, -5.00",
            "-10.00, 15.0, -25.00",
            "80.79, 1.01, 79.78",
            "0.000001, 0.000001, 0.000000",
    })
    void apply(BigDecimal firstOperand, BigDecimal secondOperand, BigDecimal result) {
        assertEquals(result, subtractionOperation.apply(firstOperand, secondOperand));
    }
}