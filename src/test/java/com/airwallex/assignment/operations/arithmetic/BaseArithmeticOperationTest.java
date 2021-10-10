package com.airwallex.assignment.operations.arithmetic;

import com.airwallex.assignment.exceptions.InsufficientNumberOfArgumentsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link BaseArithmeticOperation} class
 */
class BaseArithmeticOperationTest {

    private BaseArithmeticOperation newOperation;

    @BeforeEach
    public void init() {
        newOperation = new BaseArithmeticOperation() {
            @Override
            public int getNumberOfOperands() {
                return 2;
            }

            @Override
            public BigDecimal apply(BigDecimal firstOperand, BigDecimal secondOperand) {
                return firstOperand.add(secondOperand);
            }

            @Override
            public String getOperationSign() {
                return "x";
            }
        };
    }

    @Test
    public void execute_shouldSaveInformationToHistoryAndStack() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(new BigDecimal(10));
        stack.push(new BigDecimal(15));
        Stack<Stack<BigDecimal>> history = new Stack<>();

        newOperation.execute(stack, history);

        assertEquals(1, stack.size());
        assertEquals(new BigDecimal(25), stack.peek());
        assertEquals(1, history.size());
    }

    @Test
    public void execute_failsWhenNumberOfOperandsInStackIsLessThanRequired() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(new BigDecimal(10));
        Stack<Stack<BigDecimal>> history = new Stack<>();

        assertThrows(InsufficientNumberOfArgumentsException.class, () -> newOperation.execute(stack, history));
    }
}