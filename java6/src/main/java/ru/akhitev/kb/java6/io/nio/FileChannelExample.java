package ru.akhitev.kb.java6.io.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelExample {
    public static void main(String[] args) {
        String fromTest3 = readFile("/home/aleksei_khitev/test_3.txt");
        System.out.println("From test_3:\n--------");
        System.out.println(fromTest3);
        System.out.println("--------");
        System.out.println("Writing to test_7. Channel from FileOutputStream");
        String fileNameTest7 = "/home/aleksei_khitev/test_7.txt";
        writeFile(fileNameTest7, fromTest3);
        System.out.println("From test_7:\n--------");
        System.out.println(readFile(fileNameTest7));
        System.out.println("--------");
        System.out.println("Writing to test_7. Channel from RandomAccessFile");
        appendFile(fileNameTest7, "Appended");
        System.out.println("From test_7:\n--------");
        System.out.println(readFile(fileNameTest7));
        System.out.println("--------");
    }

    private static String readFile(String fileName) {
        StringBuilder result = new StringBuilder();
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             FileChannel fileChannel = fileInputStream.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            fileChannel.read(buffer);
            buffer.flip();
            while(buffer.hasRemaining()) {
                result.append((char) buffer.get());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    private static void writeFile(String fileName, String text) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            FileChannel fileChannel = fileOutputStream.getChannel()) {
            ByteBuffer buffer = ByteBuffer.wrap(text.getBytes());
            fileChannel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void appendFile(String fileName, String text) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
            FileChannel fileChannel = randomAccessFile.getChannel()) {
            fileChannel.position(fileChannel.size()); // Перемещение в конец
            ByteBuffer buffer = ByteBuffer.wrap(text.getBytes());
            fileChannel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
