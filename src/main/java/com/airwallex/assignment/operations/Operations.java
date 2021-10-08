package com.airwallex.assignment.operations;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.Stack;

public enum Operations {

    // TODO validate that stack is not empty
    ADDITION("+", (stack, history) -> {
        validateStack(stack.size(), Operations.TWO_OPERANDS);
        history.push((Stack<BigDecimal>) stack.clone());
        stack.push(stack.pop().add(stack.pop()));
    }),
    SUBTRACTION("-", (stack, history) -> {
        validateStack(stack.size(), Operations.TWO_OPERANDS);
        history.push((Stack<BigDecimal>) stack.clone());
        stack.push(stack.pop().subtract(stack.pop()));
    }),
    MULTIPLICATION("*", (stack, history) -> {
        validateStack(stack.size(), Operations.TWO_OPERANDS);
        history.push((Stack<BigDecimal>) stack.clone());
        stack.push(stack.pop().multiply(stack.pop()));
    }),
    DIVISION("/", (stack, history) -> {
        validateStack(stack.size(), Operations.TWO_OPERANDS);
        history.push((Stack<BigDecimal>) stack.clone());
        stack.push(stack.pop().divide(stack.pop()));
    }),
    CLEAR("clear", (stack, history) -> {
        history.push((Stack<BigDecimal>) stack.clone());
        stack.clear();
    }),
    SQRT("sqrt", (stack, history) -> {
        validateStack(stack.size(), Operations.ONE_OPERAND);
        history.push((Stack<BigDecimal>) stack.clone());
        stack.push(stack.pop().sqrt(MathContext.DECIMAL128));
    }),
    UNDO("undo", (stack, history) -> {
        stack.clear();
        history.pop().forEach(stack::push);
//        System.out.println("---------------");
//        System.out.println(stack);
//        System.out.println("---------------");
    });

    private static final int ONE_OPERAND = 1;
    private static final int TWO_OPERANDS = 2;

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

    private static void validateStack(int stackSize, int expectedNumberOfOperands) {
        if (stackSize < expectedNumberOfOperands) {
            throw new ArithmeticException("Number of operands is less than " + expectedNumberOfOperands);
        }
    }

    public Operation getOperation() {
        return operation;
    }
    // TODO add decimal format
}
