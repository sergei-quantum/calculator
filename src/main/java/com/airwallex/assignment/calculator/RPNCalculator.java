package com.airwallex.assignment.calculator;

import com.airwallex.assignment.exceptions.InsufficientNumberOfArgumentsException;
import com.airwallex.assignment.operations.Operations;
import com.airwallex.assignment.utils.CalculatorUtils;

import java.math.BigDecimal;
import java.util.Stack;

public class RPNCalculator {

    private final Stack<Stack<BigDecimal>> history = new Stack<>();
    private final Stack<BigDecimal> operandStack = new Stack<>();

    public Stack<BigDecimal> getOperandStack() {
        return CalculatorUtils.copyStack(operandStack);
    }

    public void execute(String expression) {
        int position = 0;
        try {
            for (String token : expression.split(" ")) {
                position = position + token.length();
                if (CalculatorUtils.isNumber(token)) {
                    history.push(CalculatorUtils.copyStack(operandStack));
                    operandStack.push(new BigDecimal(token));
                } else {
                    Operations.parseOperation(token)
                            .orElseThrow(() -> new IllegalArgumentException("Not supported operation"))
                            .execute(operandStack, history);
                }
                position++;
            }
        } catch (InsufficientNumberOfArgumentsException e) {
            System.out.println(String.format("operator: %s (position %d) insufficient parameters", e.getOperatorName(), position));
        }
        System.out.print("stack: ");
        this.operandStack.forEach(entry -> System.out.print(entry.stripTrailingZeros() + " "));
        System.out.println();
    }
}
