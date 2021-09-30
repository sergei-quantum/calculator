package com.airwallex.assignment.ui;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Represents simple user interface using console possibilities
 */
public class ConsoleReader {

    private final Scanner scanner;

    /**
     * Constructor with parameters.
     *
     * @param source source of the input
     */
    public ConsoleReader(InputStream source) {
        this.scanner = new Scanner(source);
    }

    /**
     * Reads and validates expression entered by user
     *
     * @return expression
     */
    public String readInputExpression() {
        return scanner.nextLine();
    }

}
