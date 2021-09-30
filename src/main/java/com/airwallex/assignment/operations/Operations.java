package com.airwallex.assignment.operations;

import java.util.Arrays;
import java.util.Stack;

public enum Operations {
    // TODO validate that stack is not empty
    ADDITION("+", (stack, history) -> {
        history.push((Stack<Double>) stack.clone());
        double operand1 = stack.pop();
        double operand2 = stack.pop();
        double result = operand1 + operand2;
        stack.push(result);
    }),
    SUBTRACTION("-", (stack, history) -> {
        history.push((Stack<Double>) stack.clone());
        double operand1 = stack.pop();
        double operand2 = stack.pop();
        double result = operand1 - operand2;
        stack.push(result);
    }),
    MULTIPLICATION("*", (stack, history) -> {
        history.push((Stack<Double>) stack.clone());
        double operand1 = stack.pop();
        double operand2 = stack.pop();
        double result = operand1 * operand2;
        stack.push(result);
    }),
    DIVISION("/", (stack, history) -> {
        history.push((Stack<Double>) stack.clone());
        double operand1 = stack.pop();
        double operand2 = stack.pop();
        double result = operand1 / operand2;
        stack.push(result);
    }),
    CLEAR("clear", (stack, history) -> {
        history.push(stack);
        stack.clear();
    }),
    UNDO("undo", (stack, history) -> {
        stack.clear();
        history.pop().forEach(stack::push);
    });


    private final String operationName;
    private final Operation operation;

    Operations(String operator, Operation operation) {
        this.operationName = operator;
        this.operation = operation;
    }

    public static Operations parseOperation(String operationString) {
        return Arrays.stream(Operations.values())
                .filter(operation -> operation.operationName.equals(operationString))
                .findAny()
                .orElse(null);
    }

    public Operation getOperation() {
        return operation;
    }
}
