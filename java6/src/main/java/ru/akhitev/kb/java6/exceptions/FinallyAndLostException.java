package ru.akhitev.kb.java6.exceptions;

public class FinallyAndLostException {
    public static void main(String[] args) {
        System.err.println("=== Lost with another exception from finally ===");
        try {
            losingWithException();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.err.println("=== Lost with return ===");
        try {
            losingWithReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void losingWithException() {
        try {
            throw new RuntimeException();
        } finally {
            throw new IllegalArgumentException();
        }
    }

    private static void losingWithReturn() {
        try {
            throw new RuntimeException();
        } finally {
            return;
        }
    }
}
