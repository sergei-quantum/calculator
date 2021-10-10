package com.airwallex.assignment.operations.arithmetic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for {@link MultiplicationOperation} class
 */
class MultiplicationOperationTest {

    private BaseArithmeticOperation multiplicationOperation;

    @BeforeEach
    public void init() {
        multiplicationOperation = new MultiplicationOperation();
    }

    @ParameterizedTest(name = "returns {2} when the first operand is {0} and the second operand is {1}")
    @CsvSource({
            "10, 10, 100",
            "10.00, 15.0, 150.000",
            "-10.00, 15.0, -150.000",
            "83.76, 5.013, 419.88888",
            "0.000001, 0.000001, 0.000000000001",
    })
    void apply(BigDecimal firstOperand, BigDecimal secondOperand, BigDecimal result) {
        assertEquals(result, multiplicationOperation.apply(firstOperand, secondOperand));
    }
}