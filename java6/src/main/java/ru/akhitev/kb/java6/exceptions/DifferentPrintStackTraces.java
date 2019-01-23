package ru.akhitev.kb.java6.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;

public class DifferentPrintStackTraces {
    public static void main(String... args) {
        usualPrintStackTrace();
        printStackTraceAndPrintStream();
        printStackTraceAndPrintWriter();
    }

    private static void usualPrintStackTrace() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    private static void printStackTraceAndPrintStream() {
        PrintStream stream = new PrintStream(System.out);
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            e.printStackTrace(stream);
        }
    }

    private static void printStackTraceAndPrintWriter() {
        PrintWriter printWriter = new PrintWriter(System.out);
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            e.printStackTrace(printWriter);
        }
        printWriter.close();
    }
}
