package ru.akhitev.kb.java6.io.archiving;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipExample {
    public static void main(String[] args) {
        String archiveName = "/home/aleksei_khitev/test_arch.gz";
        archive(archiveName);
        extract(archiveName);
    }

    private static void archive(String archiveName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(archiveName);
             GZIPOutputStream gzipOutputStream = new GZIPOutputStream(fileOutputStream);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(gzipOutputStream)) {
            bufferedOutputStream.write("Test\nlines".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void extract(String archiveName) {
        try (FileInputStream fileInputStream = new FileInputStream(archiveName);
             GZIPInputStream gzipInputStream = new GZIPInputStream(fileInputStream);
             InputStreamReader inputStreamReader = new InputStreamReader(gzipInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                System.out.println(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
