package com.airwallex.assignment.operations.arithmetic;

import com.airwallex.assignment.exceptions.ArithmeticCalculationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for {@link DivisionOperation} class
 */
class DivisionOperationTest {

    private BaseArithmeticOperation divisionOperation;

    @BeforeEach
    public void init() {
        divisionOperation = new DivisionOperation();
    }

    @ParameterizedTest(name = "returns {2} when the first operand is {0} and the second operand is {1}")
    @CsvSource({
            "10, 10, 1",
            "10.00, 5.0, 2.0",
            "1, 3, 0.3333333333333333333333333333333333",
            "-1, 4, -0.25",
            "0.000001, 0.000001, 1",
    })
    void apply_dividesSuccessfully(BigDecimal firstOperand, BigDecimal secondOperand, BigDecimal result) {
        assertEquals(result, divisionOperation.apply(firstOperand, secondOperand));
    }

    @Test
    void apply_failsToDivide() {
        BigDecimal firstOperand = new BigDecimal(1);
        BigDecimal secondOperand = new BigDecimal(0);

        Throwable throwable = assertThrows(ArithmeticCalculationException.class,
                () -> divisionOperation.apply(firstOperand, secondOperand));
        assertEquals("Division by zero", throwable.getMessage());
    }
}