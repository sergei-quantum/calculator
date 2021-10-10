package com.airwallex.assignment.operations.arithmetic;

import com.airwallex.assignment.exceptions.ArithmeticCalculationException;

import java.math.BigDecimal;

/**
 * Square root operation implementation
 */
public class SquareRootOperation extends BaseArithmeticOperation {

    @Override
    public int getNumberOfOperands() {
        return ONE_OPERAND;
    }

    @Override
    public BigDecimal apply(BigDecimal firstOperand, BigDecimal secondOperand) {
        try {
            return firstOperand.sqrt(PRECISION_THIRTY_FOUR_DIGITS);
        } catch (ArithmeticException e) {
            throw new ArithmeticCalculationException(e.getMessage(), getOperationSign());
        }
    }

    @Override
    public String getOperationSign() {
        return "sqrt";
    }
}
