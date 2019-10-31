package ru.akhitev.kb.java8.io;

import java.io.*;

public class SystemOutToFileAndBackToConsole {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Начало");
        PrintStream console = System.out;
        System.out.println("Создаем PrintStream console, чтоб не потерять и вернутся к консоли");
        System.out.println("Переключение на чтение файла и запись в файл");
        try (FileOutputStream fileOutputStream = new FileOutputStream("/home/aleksei_khitev/test_6.txt");
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
             PrintStream printStream = new PrintStream(bufferedOutputStream);
             FileInputStream fileInputStream = new FileInputStream("/home/aleksei_khitev/test_3.txt");
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) {
            System.setOut(printStream);
            System.setErr(printStream);
            System.setIn(bufferedInputStream);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(System.in));
            System.out.println("Начало записи в файл");
            String currentLineInFile;
            while ((currentLineInFile = bufferedReader.readLine()) != null) {
                System.out.println(currentLineInFile);
            }
            System.out.println("Конец записи в файл");
        } catch (IOException e) {}
        System.setOut(console);
        System.setErr(console);
        System.out.println("Вернулись в консоль");
    }

}
