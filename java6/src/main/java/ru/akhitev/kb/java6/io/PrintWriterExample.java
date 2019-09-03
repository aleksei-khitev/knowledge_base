package ru.akhitev.kb.java6.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterExample {
    public static void main(String[] args) {
        //printWriterWithBufferedWriterAndFileWriter();
        shortFormOfPrintWriter();
    }

    private static void printWriterWithBufferedWriterAndFileWriter() {
        try (FileWriter fileWriter = new FileWriter("/home/aleksei_khitev/test_3.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
            printWriter.println("test string\nfrom printwriter");
        } catch (IOException e) {}
    }

    private static void shortFormOfPrintWriter() {
        try (PrintWriter printWriter = new PrintWriter("/home/aleksei_khitev/test_4.txt")) {
            printWriter.println("test string\nfrom short printwriter");
        } catch (IOException e) {}
    }
}
