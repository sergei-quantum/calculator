package com.airwallex.assignment.calculator;

import com.airwallex.assignment.operations.Operations;
import com.airwallex.assignment.utils.Utils;

import java.util.Stack;

public class RPNCalculator {
    private final Stack<String> operatorStack = new Stack<>();
    private final Stack<Stack<Double>> history = new Stack<>();
    private Stack<Double> operandStack = new Stack<>();

    public void execute(String expression) {
        for (String token : expression.split(" ")) {
            boolean isNumber = Utils.isNumber(token);
//            if (!token.equals("undo")) {
//
//                history.push((Stack<Double>) operandStack.clone());
//            }
            if (isNumber) {
                operandStack.push(Double.parseDouble(token));

            } else {
                Operations operation = Operations.parseOperation(token);
                if (operation == null) throw new IllegalArgumentException("Not supported operation");
                operation.getOperation().execute(operandStack, history);

//                if (token.equals("clear")) {
//                    operandStack.clear();
//                } else if (token.equals("undo")) {
//                    operandStack = history.pop();
//                } else {
//                    double result;
//                    double operand1 = operandStack.pop();
//                    if (token.equals("sqrt")) {
//                        result = Math.sqrt(operand1);
//                    } else {
//                        double operand2 = operandStack.pop();
//                        switch (token) {
//                            case "/":
//                                result = operand1 / operand2;
//                                break;
//                            case "*":
//                                result = operand1 * operand2;
//                                break;
//                            case "-":
//                                result = operand1 - operand2;
//                                break;
//                            case "+":
//                                result = operand1 + operand2;
//                                break;
//                            default:
//                                throw new IllegalArgumentException("Not supported operation");
//                        }
//                    }
//                    operandStack.push(result);
//                }
            }
        }
        System.out.print("stack: ");
        this.operandStack.forEach(entry -> System.out.print(entry + " "));
        System.out.println();
    }
}
