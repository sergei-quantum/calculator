package com.airwallex.assignment.calculator;

import com.airwallex.assignment.operations.Operations;
import com.airwallex.assignment.utils.Utils;

import java.util.Stack;

public class RPNCalculator {
    private final Stack<Stack<Double>> history = new Stack<>();
    private Stack<Double> operandStack = new Stack<>();

    public void execute(String expression) {
        for (String token : expression.split(" ")) {
            if (Utils.isNumber(token)) {
                operandStack.push(Double.parseDouble(token));
            } else {
                Operations operation = Operations.parseOperation(token);
                if (operation == null) throw new IllegalArgumentException("Not supported operation");
                operation.getOperation().execute(operandStack, history);
            }
        }
        System.out.print("stack: ");
        this.operandStack.forEach(entry -> System.out.print(entry + " "));
        System.out.println();
    }
}
