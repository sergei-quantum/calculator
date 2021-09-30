package com.airwallex.assignment;

import com.airwallex.assignment.calculator.RPNCalculator;
import com.airwallex.assignment.ui.ConsoleReader;

public class Application {

    public static void main(String[] args) {
        RPNCalculator calculator = new RPNCalculator();
        ConsoleReader consoleReader = new ConsoleReader(System.in);
        System.out.println("Enter your expression to calculate the result:");
        while (true) {
            String expression = consoleReader.readInputExpression();
            calculator.execute(expression);
        }
    }
}
