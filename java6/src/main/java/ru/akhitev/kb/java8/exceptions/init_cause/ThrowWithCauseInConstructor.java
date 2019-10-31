package ru.akhitev.kb.java8.exceptions.init_cause;

import java.io.IOException;

public class ThrowWithCauseInConstructor {
    public static void main(String[] args) {
        try {
            throwAnotherExceptionWithInitCause();
        } catch (OurBusinessLogicException e) {
            e.printStackTrace();

            System.err.println("=== get cause ===");
            Throwable throwable = e.getCause();
            throwable.printStackTrace();
        }
    }

    /**
     * Whe catch checked exception and throw our own with init exception in constructor.
     * In this case we could reduce our code to single line!
     */
    private static void throwAnotherExceptionWithInitCause() {
        try {
            throw new IOException();
        } catch (IOException e) {
            throw new OurBusinessLogicException(e);
        }
    }

    /** Just some our own exception */
    private static class OurBusinessLogicException extends RuntimeException {
        private OurBusinessLogicException(IOException e) {
            super(e);
        }
    }
}
