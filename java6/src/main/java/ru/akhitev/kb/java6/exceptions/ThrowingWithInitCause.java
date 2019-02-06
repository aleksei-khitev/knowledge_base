package ru.akhitev.kb.java6.exceptions;

public class ThrowingWithInitCause {
    public static void main(String[] args) {
        System.err.println("=== with init cause ===");
        try {
            throwAnotherExceptionWithInitCause();
        } catch (Exception e) {
            e.printStackTrace();
            Throwable throwable = e.getCause();
            System.err.println("=== get cause ===");
            throwable.printStackTrace();
        }
        System.err.println("=== without init cause ===");
        try {
            throwAnotherExceptionWithoutInitCause();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void throwAnotherExceptionWithInitCause() {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            IllegalArgumentException argumentException = new IllegalArgumentException();
            argumentException.initCause(e);
            throw argumentException;
        }
    }

    private static void throwAnotherExceptionWithoutInitCause() {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            IllegalArgumentException argumentException = new IllegalArgumentException();
            throw argumentException;
        }
    }
}
