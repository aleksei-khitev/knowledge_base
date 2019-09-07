package ru.akhitev.kb.java6.io.archiving;

import java.io.*;
import java.util.zip.*;

public class ZipExample {
    public static void main(String[] args) {
        String archiveName = "/home/aleksei_khitev/test_arch2.zip";
        compress(archiveName);
        extract(archiveName);
    }

    private  static void compress(String fileName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             CheckedOutputStream checkedOutputStream =
                     new CheckedOutputStream(fileOutputStream, new Adler32());
             ZipOutputStream zipOutputStream = new ZipOutputStream(checkedOutputStream);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zipOutputStream)) {
            zipOutputStream.setComment("Test Archive");
            zipOutputStream.putNextEntry(new ZipEntry("test_1.txt"));
            bufferedOutputStream.write("text for test 1".getBytes());
            bufferedOutputStream.flush(); // Без этого, не запишется в файл
            zipOutputStream.putNextEntry(new ZipEntry("test_2.txt"));
            bufferedOutputStream.write("text for test 2".getBytes());
            bufferedOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void extract(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             CheckedInputStream checkedInputStream =
                new CheckedInputStream(fileInputStream, new Adler32());
             ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(zipInputStream)) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                System.out.println("reading " + zipEntry.getName());
                int currentLine;
                while ((currentLine = bufferedInputStream.read()) != -1) {
                    System.out.write(currentLine);
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
