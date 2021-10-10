package com.airwallex.assignment.operations.arithmetic;

import com.airwallex.assignment.exceptions.ArithmeticCalculationException;

import java.math.BigDecimal;

/**
 * Division operation implementation
 */
public class DivisionOperation extends BaseArithmeticOperation {

    @Override
    public int getNumberOfOperands() {
        return TWO_OPERANDS;
    }

    @Override
    public String getOperationSign() {
        return "/";
    }

    @Override
    public BigDecimal apply(BigDecimal firstOperand, BigDecimal secondOperand) {
        try {
            return firstOperand.divide(secondOperand, PRECISION_THIRTY_FOUR_DIGITS);
        } catch (ArithmeticException e) {
            throw new ArithmeticCalculationException(e.getMessage(), getOperationSign());
        }
    }
}
