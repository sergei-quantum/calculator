package com.airwallex.assignment.operations;

import com.airwallex.assignment.utils.CalculatorUtils;

import java.math.MathContext;
import java.util.Arrays;
import java.util.Optional;

import static com.airwallex.assignment.utils.CalculatorUtils.validateStackSize;

public enum Operations {

    ADDITION("+", (stack, history) -> {
        validateStackSize(stack.size(), Operations.TWO_OPERANDS, "+");
        history.push(CalculatorUtils.copyStack(stack));
        stack.push(stack.pop().add(stack.pop()));
    }),
    SUBTRACTION("-", (stack, history) -> {
        validateStackSize(stack.size(), Operations.TWO_OPERANDS, "-");
        history.push(CalculatorUtils.copyStack(stack));
        stack.push(stack.pop().subtract(stack.pop()));
    }),
    MULTIPLICATION("*", (stack, history) -> {
        validateStackSize(stack.size(), Operations.TWO_OPERANDS, "*");
        history.push(CalculatorUtils.copyStack(stack));
        stack.push(stack.pop().multiply(stack.pop(), MathContext.DECIMAL128));
    }),
    DIVISION("/", (stack, history) -> {
        validateStackSize(stack.size(), Operations.TWO_OPERANDS, "/");
        history.push(CalculatorUtils.copyStack(stack));
        stack.push(stack.pop().divide(stack.pop(), MathContext.DECIMAL128));
    }),
    CLEAR("clear", (stack, history) -> {
        history.push(CalculatorUtils.copyStack(stack));
        stack.clear();
    }),
    SQRT("sqrt", (stack, history) -> {
        validateStackSize(stack.size(), Operations.ONE_OPERAND, "sqrt");
        history.push(CalculatorUtils.copyStack(stack));
        stack.push(stack.pop().sqrt(MathContext.DECIMAL128));
    }),
    UNDO("undo", (stack, history) -> {
        stack.clear();
        if (!history.isEmpty()) {
            history.pop().forEach(stack::push);
        }
    });

    private static final int ONE_OPERAND = 1;
    private static final int TWO_OPERANDS = 2;

    private final String operationName;
    private final Operation operation;

    Operations(String operator, Operation operation) {
        this.operationName = operator;
        this.operation = operation;
    }

    public static Optional<Operations> parseOperation(String operationString) {
        return Arrays.stream(Operations.values())
                .filter(operation -> operation.operationName.equals(operationString))
                .findAny();
    }

    public Operation getOperation() {
        return operation;
    }
}
