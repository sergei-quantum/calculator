package com.airwallex.assignment.exceptions;

public class InsufficientNumberOfArgumentsException extends RuntimeException {
    private String operatorName;

    public InsufficientNumberOfArgumentsException(String message, String operatorName) {
        super(message);
        this.operatorName = operatorName;
    }

    public String getOperatorName() {
        return operatorName;
    }
}
