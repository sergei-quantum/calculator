package com.airwallex.assignment.ui;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for {@link ConsoleReader} class
 */
class ConsoleReaderTest {

    @Test
    public void readInputExpression_readsLineSuccessfully() {
        String expectedString = "test string";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(expectedString.getBytes()));

        ConsoleReader consoleReader = new ConsoleReader(System.in);
        System.setIn(stdin);
        String result = consoleReader.readInputExpression();

        assertEquals(expectedString, result);
    }

}