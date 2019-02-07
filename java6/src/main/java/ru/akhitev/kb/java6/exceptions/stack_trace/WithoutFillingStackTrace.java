package ru.akhitev.kb.java6.exceptions.stack_trace;

public class WithoutFillingStackTrace {
    public static void main(String[] args) {
        try {
            justReThrowing();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Just throwing catched exception further.
     * In this case you will not see this place in stack trace.
     */
    private static void justReThrowing() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            // some steps
            throw e;
        }
    }
}
