package com.airwallex.assignment.operations;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Stack;

/**
 * Represents base operation abstract class with history support
 */
public abstract class BaseOperation {

    /**
     * Precision setting for calculations matching the IEEE 754R Decimal128 format, 34 digits.
     */
    protected static final MathContext PRECISION_THIRTY_FOUR_DIGITS = MathContext.DECIMAL128;

    /**
     * Applies the operation on the provided stack, adds stack changes to history stack
     *
     * @param stack   stack to operate
     * @param history historical stack data
     * @throws com.airwallex.assignment.exceptions.BaseCalculatorException if something goes wrong during execution
     */
    public abstract void execute(Stack<BigDecimal> stack, Stack<Stack<BigDecimal>> history);

    /**
     * Returns the String representation of sign
     *
     * @return string sign representation
     */
    public abstract String getOperationSign();
}
