package ru.akhitev.kb.java6.exceptions.finally_lost_exception;

public class LostByAnotherException {
    public static void main(String[] args) {
        try {
            lostByReturnInFinally();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Even if an exception is thrown in try block,
     * exception from finally overrides it.
     */
    private static void lostByReturnInFinally() {
        try {
            throw new RuntimeException();
        } finally {
            throw new IllegalArgumentException();
        }
    }
}
