package com.airwallex.assignment.operations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for {@link com.airwallex.assignment.operations.arithmetic.SubtractionOperation} class
 */
class ClearOperationTest {

    private BaseOperation clearOperation;

    @BeforeEach
    public void init() {
        clearOperation = new ClearOperation();
    }

    @Test
    public void execute_shouldSaveInformationToHistoryAndClearStack() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(new BigDecimal(10));
        stack.push(new BigDecimal(15));
        stack.push(new BigDecimal(35));
        Stack<Stack<BigDecimal>> history = new Stack<>();

        clearOperation.execute(stack, history);

        assertTrue(stack.isEmpty());

        Stack<BigDecimal> expectedStack = new Stack<>();
        expectedStack.push(new BigDecimal(10));
        expectedStack.push(new BigDecimal(15));
        expectedStack.push(new BigDecimal(35));
        assertEquals(expectedStack, history.peek());
    }
}