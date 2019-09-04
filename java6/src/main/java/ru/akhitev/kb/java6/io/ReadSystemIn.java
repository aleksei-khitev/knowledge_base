package ru.akhitev.kb.java6.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadSystemIn {
    public static void main(String[] args) {

        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null && currentLine.length() != 0) {
                System.out.println(currentLine);
            }
        } catch (IOException e) {}
    }
}
