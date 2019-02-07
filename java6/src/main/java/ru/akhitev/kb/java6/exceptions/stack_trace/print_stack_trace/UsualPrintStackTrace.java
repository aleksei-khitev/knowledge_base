package ru.akhitev.kb.java6.exceptions.stack_trace.print_stack_trace;

public class UsualPrintStackTrace {

    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

}
