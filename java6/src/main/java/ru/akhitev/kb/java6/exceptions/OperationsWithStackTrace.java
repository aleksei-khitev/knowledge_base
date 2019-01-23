package ru.akhitev.kb.java6.exceptions;

import java.util.Arrays;

public class OperationsWithStackTrace {
    public static void main(String... args) {
        getStackTrace();
    }

    private static void getStackTrace() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            StackTraceElement[] trace = e.getStackTrace();
            System.out.println(Arrays.toString(trace));
        }
    }
}
