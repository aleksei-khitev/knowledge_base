package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecutExternalApp {
    public static void main(String[] args) throws IOException {
        String command = "ls /";
        String[] splittedCommandAndArguments = command.split(" ");
        ProcessBuilder processBuilder = new ProcessBuilder(splittedCommandAndArguments);
        Process process = processBuilder.start();

        InputStreamReader resultInputStreamReader = new InputStreamReader(process.getInputStream());
        BufferedReader resultBufferedReader = new BufferedReader(resultInputStreamReader);

        InputStreamReader errorInputStreamReader = new InputStreamReader(process.getInputStream());
        BufferedReader errorBufferedReader = new BufferedReader(errorInputStreamReader);

        String currentLine;
        while ((currentLine = resultBufferedReader.readLine()) != null) {
            System.out.println(currentLine);
        }
        while ((currentLine = errorBufferedReader.readLine()) != null) {
            System.err.println(currentLine);
        }
    }
}
