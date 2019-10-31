package ru.akhitev.kb.java8.multithreading.interrupt;

import java.io.*;

public class WaitingForIoTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Ожидание ввода");
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null && currentLine.length() != 0) {
                System.out.println(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
