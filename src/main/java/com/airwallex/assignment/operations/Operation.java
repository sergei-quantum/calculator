package com.airwallex.assignment.operations;

import java.util.Stack;

@FunctionalInterface
public interface Operation {
    void execute(Stack<Double> stack, Stack<Stack<Double>> history);
}
