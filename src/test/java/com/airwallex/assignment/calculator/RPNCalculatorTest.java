package com.airwallex.assignment.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RPNCalculatorTest {

    @Test
    public void executeTest() {
        RPNCalculator calculator = new RPNCalculator();
        calculator.execute("5 4 3 2");
        calculator.execute("undo undo *");
        calculator.execute("5 *");
        calculator.execute("undo");
    }

    @ParameterizedTest(name = "returns {1} when expression is {0}")
    @CsvSource({
            "7 8 +, 15",
            "3.0 4.1 +, 7.1",
            "5 3 4 2 + + *, 45",
            "4 sqrt, 2",
            "2 6 /, 3",
            "9 3 *, 27",
    })
    public void testExecute(String expression, BigDecimal expectedResult) {
        RPNCalculator calculator = new RPNCalculator();
        calculator.execute(expression);
        assertEquals(calculator.getOperandStack().peek(), expectedResult);
    }

    //TODO to test
    @ParameterizedTest(name = "returns {1} when expression is {0}")
    @CsvSource({
            "1 0 /, 15",
            "6 2 /, 7.1",
    })
    public void testExecute_fail(String expression, BigDecimal expectedResult) {
        RPNCalculator calculator = new RPNCalculator();
        calculator.execute(expression);
        assertEquals(calculator.getOperandStack().peek(), expectedResult);
    }

}