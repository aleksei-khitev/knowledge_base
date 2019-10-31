package ru.akhitev.kb.java8.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class ReadFile {
    public static void main(String[] args) throws URISyntaxException {
        String filePath = prepareFileNameFromResources();
        String result = null;
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            StringBuilder stringBuilder = new StringBuilder();
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(currentLine);
                stringBuilder.append("\n");
            }
            result = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    private static String prepareFileNameFromResources() throws URISyntaxException {
        URL resource = ReadFile.class.getResource("/file_reader_test_file.txt");
        return resource.toURI().getPath();
    }
}
