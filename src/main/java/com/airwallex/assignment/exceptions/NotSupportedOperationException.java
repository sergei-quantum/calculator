package com.airwallex.assignment.exceptions;

public class NotSupportedOperationException extends  BaseCalculatorException{
    /**
     * Constructor with parameters
     *
     * @param message       exception message
     * @param operationName name of the operation
     */
    public NotSupportedOperationException(String message, String operationName) {
        super(message, operationName);
    }
}
