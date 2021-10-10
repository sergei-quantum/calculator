package com.airwallex.assignment.operations;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Undo operation implementation.
 * Restores the previous stack's state by clearing the stack, extracting information from history and adding it to stack
 */
public class UndoOperation extends BaseOperation {
    @Override
    public void execute(Stack<BigDecimal> stack, Stack<Stack<BigDecimal>> history) {
        stack.clear();
        if (!history.isEmpty()) {
            history.pop().forEach(stack::push);
        }
    }

    @Override
    public String getOperationSign() {
        return "undo";
    }
}
