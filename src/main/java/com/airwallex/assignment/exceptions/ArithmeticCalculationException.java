package com.airwallex.assignment.exceptions;

/**
 * Arithmetic exception class.
 * Can be used when something is happening during execution of arithmetic operation
 */
public class ArithmeticCalculationException extends BaseCalculatorException {
    /**
     * Constructor with parameters
     *
     * @param message       exception message
     * @param operationName name of the operation
     */
    public ArithmeticCalculationException(String message, String operationName) {
        super(message, operationName);
    }
}
