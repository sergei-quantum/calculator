package com.airwallex.assignment.operations.arithmetic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for {@link AdditionOperation} class
 */
class AdditionOperationTest {

    private BaseArithmeticOperation additionOperation;

    @BeforeEach
    public void init() {
        additionOperation = new AdditionOperation();
    }

    @ParameterizedTest(name = "returns {2} when the first operand is {0} and the second operand is {1}")
    @CsvSource({
            "10, 10, 20",
            "10.00, 15.0, 25.00",
            "-10.00, 15.0, 5.00",
            "80.79, 1.01, 81.80",
            "0.000001, 0.000001, 0.000002",
    })
    void apply(BigDecimal firstOperand, BigDecimal secondOperand, BigDecimal result) {
        assertEquals(result, additionOperation.apply(firstOperand, secondOperand));
    }
}