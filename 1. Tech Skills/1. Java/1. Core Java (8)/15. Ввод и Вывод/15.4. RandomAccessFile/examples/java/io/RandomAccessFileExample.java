package io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileExample {
    private static final String FILE_NAME = "/home/aleksei_khitev/test_5.txt";

    public static void main(String[] args) throws IOException {
        fillFile();
        readFile();
        appendWithSeek();
        readFile();
    }

    private static void fillFile() throws IOException {
        String accessMode = "rw";
        RandomAccessFile randomAccessFile = new RandomAccessFile(FILE_NAME, accessMode);
        randomAccessFile.writeInt(1234);
        randomAccessFile.writeDouble(1.45);
        randomAccessFile.writeChar('d');
        randomAccessFile.writeUTF("Тестовая строка");
        randomAccessFile.close();
    }

    private static void readFile() throws IOException {
        String accessMode = "r";
        RandomAccessFile randomAccessFile = new RandomAccessFile(FILE_NAME, accessMode);
        System.out.println(randomAccessFile.readInt());
        System.out.println(randomAccessFile.readDouble());
        System.out.println(randomAccessFile.readChar());
        System.out.println(randomAccessFile.readUTF());
        randomAccessFile.close();
    }

    private static void appendWithSeek() throws IOException {
        String accessMode = "rw";
        RandomAccessFile randomAccessFile = new RandomAccessFile(FILE_NAME, accessMode);
        randomAccessFile.seek(3);
        randomAccessFile.writeByte(1);
        randomAccessFile.close();
    }
}
