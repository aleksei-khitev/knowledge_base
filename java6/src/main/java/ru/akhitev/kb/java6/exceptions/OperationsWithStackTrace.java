package ru.akhitev.kb.java6.exceptions;

import java.util.Arrays;

public class OperationsWithStackTrace {
    public static void main(String... args) {
        //getStackTrace();
        compareWithAndWithputStackTrace();
    }

    private static void getStackTrace() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            StackTraceElement[] trace = e.getStackTrace();
            System.out.println(Arrays.toString(trace));
        }
    }

    private static void compareWithAndWithputStackTrace() {
        try {
            throwWithFillStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        try {
            throwWithoutFillStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    private static void throwWithFillStackTrace() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            throw (RuntimeException) e.fillInStackTrace();
        }
    }

    private static void throwWithoutFillStackTrace() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            throw e;
        }
    }
}
