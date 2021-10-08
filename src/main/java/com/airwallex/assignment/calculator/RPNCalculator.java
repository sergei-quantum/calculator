package com.airwallex.assignment.calculator;

import com.airwallex.assignment.operations.Operations;
import com.airwallex.assignment.utils.Utils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class RPNCalculator {

    private final Stack<Stack<BigDecimal>> history = new Stack<>();

    public Stack<BigDecimal> getOperandStack() {
        return (Stack<BigDecimal>) operandStack.clone();
    }

    private final Stack<BigDecimal> operandStack = new Stack<>();

    public void execute(String expression) {
        for (String token : expression.split(" ")) {
            if (Utils.isNumber(token)) {
                history.push((Stack<BigDecimal>) operandStack.clone());
                operandStack.push(new BigDecimal(token));
            } else {
                Operations operation = Operations.parseOperation(token);
                if (operation == null) throw new IllegalArgumentException("Not supported operation");
                operation.getOperation().execute(operandStack, history);
            }
        }
//        1 2 3 * 5 + * * 6 5
        System.out.print("stack: ");
        this.operandStack.forEach(entry -> System.out.print(entry + " "));
        System.out.println();
    }


}
