package com.airwallex.assignment.operations.arithmetic;

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
        return firstOperand.sqrt(PRECISION_THIRTY_FOUR_DIGITS);
    }

    @Override
    public String getOperationSign() {
        return "sqrt";
    }
}
