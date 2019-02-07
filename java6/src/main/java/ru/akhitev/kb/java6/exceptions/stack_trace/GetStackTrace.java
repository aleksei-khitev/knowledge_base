package ru.akhitev.kb.java6.exceptions.stack_trace;

import java.util.Arrays;

public class GetStackTrace {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            StackTraceElement[] trace = e.getStackTrace();
            System.out.println(Arrays.toString(trace));
        }

    }
}
