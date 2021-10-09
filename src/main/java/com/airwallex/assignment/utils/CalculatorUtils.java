package com.airwallex.assignment.utils;

import com.airwallex.assignment.exceptions.InsufficientNumberOfArgumentsException;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Calculator utility class.
 */
public class CalculatorUtils {

    /**
     * Checks whether provided string is number or not
     *
     * @param string string to validate
     * @return true or false value
     */
    public static boolean isNumber(String string) {
        try {
            Double.parseDouble(string);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    /**
     * Validates stack size. If number
     *
     * @param stackSize                size of the stack
     * @param expectedNumberOfOperands expected number of arguments for operation
     * @param operationName            name of the operation
     * @throws InsufficientNumberOfArgumentsException if stack size is less than number of expected arguments
     */
    public static void validateStackSize(int stackSize, int expectedNumberOfOperands, String operationName) {
        if (stackSize < expectedNumberOfOperands) {
            throw new InsufficientNumberOfArgumentsException("Number of operands is less than " + expectedNumberOfOperands, operationName);
        }
    }

    /**
     * Creates a copy of the stack
     *
     * @param stack stack to copy
     * @return new stack
     */
    public static Stack<BigDecimal> copyStack(Stack<BigDecimal> stack) {
        return (Stack<BigDecimal>) stack.clone();
    }
}
