package com.airwallex.assignment.operations;

import java.util.Stack;

@FunctionalInterface
public interface Operation {
    void execute(Stack<BigDecimal> stack, Stack<Stack<BigDecimal>> history);
}
