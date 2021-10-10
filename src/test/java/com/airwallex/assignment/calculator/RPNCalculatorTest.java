package com.airwallex.assignment.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for {@link RPNCalculator} class
 */
class RPNCalculatorTest {

    private RPNCalculator calculator;

    @BeforeEach
    public void init() {
        calculator = new RPNCalculator();
    }

    @Test
    public void execute_example1() {
        calculator.execute("5 2");

        Stack<BigDecimal> operandStack = calculator.getOperandStack();
        assertEquals(new BigDecimal("2"), operandStack.pop());
        assertEquals(new BigDecimal("5"), operandStack.pop());
    }

    @Test
    public void execute_example2() {
        calculator.execute("2 sqrt");
        assertEquals(new BigDecimal("1.414213562373095048801688724209698"), calculator.getOperandStack().peek());

        calculator.execute("clear 9 sqrt");
        assertEquals(new BigDecimal("3"), calculator.getOperandStack().peek());
    }

    @Test
    public void execute_example3() {
        calculator.execute("5 2 -");
        assertEquals(new BigDecimal("3"), calculator.getOperandStack().peek());

        calculator.execute("3 -");
        assertEquals(new BigDecimal("0"), calculator.getOperandStack().peek());

        calculator.execute("clear");
        assertTrue(calculator.getOperandStack().isEmpty());
    }

    @Test
    public void execute_example4() {
        calculator.execute("5 4 3 2");
        Stack<BigDecimal> stackAfterFirstIteration = new Stack<>();
        stackAfterFirstIteration.addAll(Arrays.asList(new BigDecimal(5), new BigDecimal(4),
                new BigDecimal(3), new BigDecimal(2)));
        assertEquals(stackAfterFirstIteration, calculator.getOperandStack());

        calculator.execute("undo undo *");
        assertEquals(new BigDecimal(20), calculator.getOperandStack().peek());

        calculator.execute("5 *");
        assertEquals(new BigDecimal(100), calculator.getOperandStack().peek());

        calculator.execute("undo");
        Stack<BigDecimal> stackAfterFourthIteration = new Stack<>();
        stackAfterFourthIteration.addAll(Arrays.asList(new BigDecimal(20), new BigDecimal(5)));
        assertEquals(stackAfterFourthIteration, calculator.getOperandStack());
    }

    @Test
    public void execute_example5() {
        calculator.execute("7 12 2 /");
        Stack<BigDecimal> stackAfterFirstIteration = new Stack<>();
        stackAfterFirstIteration.addAll(Arrays.asList(new BigDecimal(7), new BigDecimal(6)));
        assertEquals(stackAfterFirstIteration, calculator.getOperandStack());

        calculator.execute("*");
        assertEquals(new BigDecimal(42), calculator.getOperandStack().peek());

        calculator.execute("4 /");
        assertEquals(new BigDecimal(10.5), calculator.getOperandStack().peek());
    }

    @Test
    public void execute_example6() {
        calculator.execute("1 2 3 4 5");
        Stack<BigDecimal> stackAfterFirstIteration = new Stack<>();
        stackAfterFirstIteration.addAll(Arrays.asList(new BigDecimal(1), new BigDecimal(2),
                new BigDecimal(3), new BigDecimal(4), new BigDecimal(5)));
        assertEquals(stackAfterFirstIteration, calculator.getOperandStack());

        calculator.execute("*");
        Stack<BigDecimal> stackAfterSecondIteration = new Stack<>();
        stackAfterSecondIteration.addAll(Arrays.asList(new BigDecimal(1), new BigDecimal(2),
                new BigDecimal(3), new BigDecimal(20)));
        assertEquals(stackAfterSecondIteration, calculator.getOperandStack());

        calculator.execute("clear 3 4 -");
        assertEquals(new BigDecimal(-1), calculator.getOperandStack().peek());
    }

    @Test
    public void execute_example7() {
        calculator.execute("1 2 3 4 5");
        Stack<BigDecimal> stackAfterFirstIteration = new Stack<>();
        stackAfterFirstIteration.addAll(Arrays.asList(new BigDecimal(1), new BigDecimal(2),
                new BigDecimal(3), new BigDecimal(4), new BigDecimal(5)));
        assertEquals(stackAfterFirstIteration, calculator.getOperandStack());

        calculator.execute("* * * *");
        assertEquals(new BigDecimal(120), calculator.getOperandStack().peek());
    }

    @Test
    public void execute_example8() {
        calculator.execute("1 2 3 * 5 + * * 6 5");
        assertEquals(new BigDecimal(11), calculator.getOperandStack().peek());
    }

    @ParameterizedTest(name = "returns {1} when expression is {0}")
    @CsvSource({
            "7 8 +, 15",
            "3.0 4.1 +, 7.1",
            "5 3 4 2 + + *, 45",
            "4 sqrt, 2",
            "6 2 /, 3",
            "9 3 *, 27",
    })
    public void execute_successfullyAppliesOperations(String expression, BigDecimal expectedResult) {
        calculator.execute(expression);

        assertEquals(calculator.getOperandStack().peek(), expectedResult);
    }

    @ParameterizedTest(name = "Operation fails for {0} expression and doesn't save result to stack")
    @CsvSource({
            "1 0 /",
            "-1 sqrt",
    })
    public void execute_stackIsEmptyWhenOperationFailedToApply(String expression) {
        calculator.execute(expression);

        assertTrue(calculator.getOperandStack().empty());
    }

    @Test
    public void execute_savesOperandStacksStateWhenNotSupportedOperationIsPresent() {
        calculator.execute("1 2 newOperation");

        assertEquals(2, calculator.getOperandStack().size());
    }
}