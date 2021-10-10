package com.airwallex.assignment.operations;

import com.airwallex.assignment.utils.CalculatorUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link UndoOperation} class
 */
class UndoOperationTest {

    private BaseOperation undoOperation;

    @BeforeEach
    public void init() {
        undoOperation = new UndoOperation();
    }

    @Test
    public void execute_shouldExtractInformationFromHistoryAndPushToStack() {
        Stack<BigDecimal> stack = new Stack<>();
        stack.push(new BigDecimal(10));

        Stack<Stack<BigDecimal>> history = new Stack<>();
        history.add(CalculatorUtils.copyStack(stack));
        stack.push(new BigDecimal(15));
        history.add(CalculatorUtils.copyStack(stack));

        undoOperation.execute(stack, history);

        Stack<BigDecimal> expectedStack = new Stack<>();
        expectedStack.push(new BigDecimal(10));
        expectedStack.push(new BigDecimal(15));
        assertEquals(expectedStack, stack, "stacks should be equal");

        assertEquals(1, history.size(), "history size must be 1 after undo operation");

        undoOperation.execute(stack, history);
        expectedStack.pop();
        assertEquals(expectedStack, stack, "stacks should be equal");

        assertEquals(0, history.size(), "history size must be 0 after one more undo operation");
    }
}