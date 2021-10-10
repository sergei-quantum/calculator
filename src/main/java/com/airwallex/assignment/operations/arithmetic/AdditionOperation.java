package com.airwallex.assignment.operations.arithmetic;

import java.math.BigDecimal;

/**
 * Addition operation implementation
 */
public class AdditionOperation extends BaseArithmeticOperation {

    @Override
    public int getNumberOfOperands() {
        return TWO_OPERANDS;
    }

    @Override
    public String getOperationSign() {
        return "+";
    }

    @Override
    public BigDecimal apply(BigDecimal firstOperand, BigDecimal secondOperand) {
        return firstOperand.add(secondOperand, PRECISION_THIRTY_FOUR_DIGITS);
    }
}
