package com.airwallex.assignment.operations.arithmetic;

import com.airwallex.assignment.operations.BaseOperation;
import com.airwallex.assignment.utils.CalculatorUtils;

import java.math.BigDecimal;
import java.util.Stack;

import static com.airwallex.assignment.utils.CalculatorUtils.validateStackSize;

/**
 * Base abstract arithmetic operation class.
 * Provides functionality for validating stack, saving stack state to history and pushing result into stack.
 * All arithmetic operations (such as addition, multiplication) must extend this abstract class.
 */
public abstract class BaseArithmeticOperation extends BaseOperation {

    /**
     * Constant int representation for one operand
     */
    protected static final int ONE_OPERAND = 1;

    /**
     * Constant int representation for two operands
     */
    protected static final int TWO_OPERANDS = 2;

    @Override
    public void execute(Stack<BigDecimal> stack, Stack<Stack<BigDecimal>> history) {
        validateStackSize(stack.size(), this.getNumberOfOperands(), this.getOperationSign());
        history.push(CalculatorUtils.copyStack(stack));
        BigDecimal result = apply(stack.pop(), getNumberOfOperands() > 1 ? stack.pop() : null);
        stack.push(result);
    }

    /**
     * Abstract function that returns number of required operands for operation.
     * Values {@value ONE_OPERAND} and {@value TWO_OPERANDS} can be used.
     *
     * @return number of operands
     */
    public abstract int getNumberOfOperands();

    /**
     * Abstract function that calculates the result of operation.
     * If number of operands is {@value ONE_OPERAND} use only the first argument to calculate the result.
     *
     * @param firstOperand  first operand
     * @param secondOperand second operand
     * @return result of operation
     */
    public abstract BigDecimal apply(BigDecimal firstOperand, BigDecimal secondOperand);
}
