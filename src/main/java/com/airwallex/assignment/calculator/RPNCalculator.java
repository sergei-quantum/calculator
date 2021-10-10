package com.airwallex.assignment.calculator;

import com.airwallex.assignment.exceptions.BaseCalculatorException;
import com.airwallex.assignment.exceptions.InsufficientNumberOfArgumentsException;
import com.airwallex.assignment.exceptions.NotSupportedOperationException;
import com.airwallex.assignment.operations.Operations;
import com.airwallex.assignment.utils.CalculatorUtils;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Reverse polish notation calculator with history support
 */
public class RPNCalculator {

    /**
     * Stack where data and operation results are stored
     */
    private final Stack<BigDecimal> operandStack = new Stack<>();

    /**
     * Stack where each state of operand stack is stored
     */
    private final Stack<Stack<BigDecimal>> history = new Stack<>();

    /**
     * Returns copy of operand stack
     *
     * @return copy of operand stack
     */
    public Stack<BigDecimal> getOperandStack() {
        return CalculatorUtils.copyStack(operandStack);
    }

    /**
     * Main execute function for calculating results of provided expression.
     * Adds all the intermediate and final results to {@link RPNCalculator#operandStack}
     * and {@link RPNCalculator#history}
     *
     * @param expression expression to execute
     * @throws IllegalArgumentException if expression contains not supported operations
     */
    public void execute(String expression) {
        int position = 0;
        try {
            for (String token : expression.split(" ")) {
                position++;
                if (CalculatorUtils.isNumber(token)) {
                    history.push(CalculatorUtils.copyStack(operandStack));
                    operandStack.push(new BigDecimal(token));
                } else {
                    Operations.parseOperation(token)
                            .orElseThrow(() -> new NotSupportedOperationException("Not supported operation", token))
                            .execute(operandStack, history);
                }
                position = position + token.length();
            }
        } catch (InsufficientNumberOfArgumentsException e) {
            System.out.println(String.format("operator: %s (position %d) insufficient parameters",
                    e.getOperationName(), position));
        } catch (BaseCalculatorException e) {
            System.out.println(String.format("operator: %s (position %d) failed to apply operation",
                    e.getOperationName(), position));
        }
        System.out.print("stack: ");
        this.operandStack.forEach(entry -> System.out.print(entry.stripTrailingZeros().toPlainString() + " "));
        System.out.println();
    }
}
