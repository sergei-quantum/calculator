package com.airwallex.assignment.operations.arithmetic;

import java.math.BigDecimal;

/**
 * Subtraction operation implementation
 */
public class SubtractionOperation extends BaseArithmeticOperation {

    @Override
    public int getNumberOfOperands() {
        return TWO_OPERANDS;
    }

    @Override
    public String getOperationSign() {
        return "-";
    }

    @Override
    public BigDecimal apply(BigDecimal firstOperand, BigDecimal secondOperand) {
        return firstOperand.subtract(secondOperand, PRECISION_THIRTY_FOUR_DIGITS);
    }
}
