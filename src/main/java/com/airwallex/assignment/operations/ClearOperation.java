package com.airwallex.assignment.operations;

import com.airwallex.assignment.utils.CalculatorUtils;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Clear operation implementation. Saves stack state to history and clears the stack
 */
public class ClearOperation extends BaseOperation {
    @Override
    public void execute(Stack<BigDecimal> stack, Stack<Stack<BigDecimal>> history) {
        history.push(CalculatorUtils.copyStack(stack));
        stack.clear();
    }

    @Override
    public String getOperationSign() {
        return "clear";
    }
}
