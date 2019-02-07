package ru.akhitev.kb.java6.exceptions.init_cause;

import java.io.IOException;

public class ThrowWithoutInitCauseAndConstructor {
    public static void main(String[] args) {
        try {
            throwAnotherExceptionWithoutInitCause();
        } catch (OurBusinessLogicException e) {
            e.printStackTrace();
        }
    }

    /**
     * Whe catch checked exception and throw our own without cause
     * Bad idea in most cases!
     */
    private static void throwAnotherExceptionWithoutInitCause() {
        try {
            throw new IOException();
        } catch (IOException e) {
            throw new OurBusinessLogicException();
        }
    }

    /** Just some our own exception */
    private static class OurBusinessLogicException extends RuntimeException {}
}
