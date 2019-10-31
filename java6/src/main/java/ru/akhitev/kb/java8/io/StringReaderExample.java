package ru.akhitev.kb.java8.io;

import java.io.IOException;
import java.io.StringReader;

public class StringReaderExample {
    public static void main(String[] args) throws IOException {
        String inputString = "12345\n67890";
        StringReader stringReader = new StringReader(inputString);
        int currentSybmol;
        while ((currentSybmol = stringReader.read()) != -1) {
            System.out.print((char) currentSybmol);
        }
    }
}
