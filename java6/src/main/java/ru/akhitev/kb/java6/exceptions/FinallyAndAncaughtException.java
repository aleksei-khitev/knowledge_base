package ru.akhitev.kb.java6.exceptions;

public class FinallyAndAncaughtException {
    public static void main(String[] args) {
        try {
            methodWithThrowing();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void methodWithThrowing() {
        try {
            throw new RuntimeException();
        } finally {
            System.err.println("finally");
        }
    }
}
