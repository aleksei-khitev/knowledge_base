package ru.akhitev.kb.java6.exceptions.stack_trace.print_stack_trace;

import java.io.PrintStream;

public class PrintStackTraceInPrintStream {

    public static void main(String[] args) {
        PrintStream stream = new PrintStream(System.out);
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            e.printStackTrace(stream);
        }
    }

}
