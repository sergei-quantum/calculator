package com.airwallex.assignment.exceptions;

/**
 * Runtime base calculator exception class.
 * Can be used as a base class for all exceptions in the project
 */
public class BaseCalculatorException extends RuntimeException {

    private final String operationName;

    /**
     * Constructor with parameters
     *
     * @param message       exception message
     * @param operationName name of the operation
     */
    public BaseCalculatorException(String message, String operationName) {
        super(message);
        this.operationName = operationName;
    }

    /**
     * Returns name of the operation
     *
     * @return operation name
     */
    public String getOperationName() {
        return operationName;
    }
}
