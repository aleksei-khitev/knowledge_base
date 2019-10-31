package ru.akhitev.kb.java8.exceptions.stack_trace;

public class WithFillingStackTrace {
    public static void main(String[] args) {
        try {
            throwWithFillStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Throwing catched exception further with filling stack trace.
     * In this case you will see this place in stack trace.
     */
    private static void throwWithFillStackTrace() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            // some steps
            throw (RuntimeException) e.fillInStackTrace();
        }
    }
}
