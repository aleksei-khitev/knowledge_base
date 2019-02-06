package ru.akhitev.kb.java6.exceptions;

public class FinallyAndReturn {
    public static void main(String[] args) {
        finallBeforeReturn();
        System.err.println("after return in main");
    }

    private static void finallBeforeReturn() {
        try {
            System.err.println("before return");
            return;
        } finally {
            System.err.println("finally");
        }
    }
}
