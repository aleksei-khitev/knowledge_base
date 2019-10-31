package ru.akhitev.kb.java8.exceptions.init_cause;

import java.io.IOException;

public class ThrowWithInitCause {
    public static void main(String[] args) {
        try {
            throwAnotherExceptionWithInitCause();
        } catch (OurBusinessLogicException e) {
            e.printStackTrace();
        }
    }

    /**
     * Whe catch checked exception and throw our own.
     * But here we invoke initCause() method to fill the cause
     */
    private static void throwAnotherExceptionWithInitCause() {
        try {
            throw new IOException();
        } catch (IOException e) {
            OurBusinessLogicException argumentException = new OurBusinessLogicException();
            argumentException.initCause(e);
            throw argumentException;
        }
    }

    /** Just some our own exception */
    private static class OurBusinessLogicException extends RuntimeException {}
}
