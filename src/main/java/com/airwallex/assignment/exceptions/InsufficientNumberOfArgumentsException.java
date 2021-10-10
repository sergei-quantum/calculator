package com.airwallex.assignment.exceptions;

/**
 * Insufficient number Of arguments exception class.
 * Can be used when provided arguments is not enough for operation
 */
public class InsufficientNumberOfArgumentsException extends BaseCalculatorException {

    /**
     * Constructor with parameters
     *
     * @param message       exception message
     * @param operationName name of the operation
     */
    public InsufficientNumberOfArgumentsException(String message, String operationName) {
        super(message, operationName);
    }
}
