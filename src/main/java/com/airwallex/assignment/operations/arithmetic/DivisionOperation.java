package com.airwallex.assignment.operations.arithmetic;

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
        return firstOperand.divide(secondOperand, PRECISION_THIRTY_FOUR_DIGITS);
    }
}
