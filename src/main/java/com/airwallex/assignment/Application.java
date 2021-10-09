package com.airwallex.assignment;

import com.airwallex.assignment.calculator.RPNCalculator;
import com.airwallex.assignment.ui.ConsoleReader;

public class Application {

    public static void main(String[] args) {
        RPNCalculator calculator = new RPNCalculator();
        ConsoleReader consoleReader = new ConsoleReader(System.in);

        System.out.println("Type 'exit' to stop application:");
        System.out.println("Enter your expression to calculate the result:");

        String expression = consoleReader.readInputExpression();
        while (!expression.equals("exit")) {
            calculator.execute(expression);
            expression = consoleReader.readInputExpression();
        }
    }
}
