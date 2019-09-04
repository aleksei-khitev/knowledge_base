package ru.akhitev.kb.java6.io;

import java.io.PrintWriter;

public class SystemOutToPrintWriter {
    public static void main(String[] args) {
        PrintWriter printWriter = new PrintWriter(System.out, true);
        printWriter.println("Hello from PrintWriter");
    }
}
