package com.airwallex.assignment.operations;

import com.airwallex.assignment.operations.arithmetic.*;

import java.util.Arrays;
import java.util.Optional;

/**
 * Enum with all supported operations
 */
public enum Operations {

    ADDITION(new AdditionOperation()),
    SUBTRACTION(new SubtractionOperation()),
    MULTIPLICATION(new MultiplicationOperation()),
    DIVISION(new DivisionOperation()),
    CLEAR(new ClearOperation()),
    SQRT(new SquareRootOperation()),
    UNDO(new UndoOperation());

    /**
     * Reference to operation class
     */
    private final BaseOperation operation;

    Operations(BaseOperation operation) {
        this.operation = operation;
    }

    /**
     * Transforms string operation to {@link BaseOperation}. If string operation is not found empty result is returned.
     *
     * @param operationString operation in string format
     * @return {@link Optional} with {@link BaseOperation} result, if found.
     */
    public static Optional<BaseOperation> parseOperation(String operationString) {
        return Arrays.stream(Operations.values())
                .map(entry -> entry.operation)
                .filter(operation -> operation.getOperationSign().equals(operationString))
                .findAny();
    }
}
