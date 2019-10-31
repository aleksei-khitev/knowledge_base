package ru.akhitev.kb.java8.io;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class DataInputStreamAvailability {
    public static void main(String[] args) {
        String testString = "123456789";
        byte[] testBytes = testString.getBytes();
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(testBytes);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(byteArrayInputStream);
             DataInputStream dataInputStream = new DataInputStream(bufferedInputStream)) {
            while (dataInputStream.available() != 0) {
                System.out.print((char) dataInputStream.readByte());
            }
        } catch (IOException e) {}

    }
}
