package ru.akhitev.kb.java6.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class TransferToFromExample {
    public static void main(String[] args) {
        String fromFile = "/home/aleksei_khitev/test_3.txt";
        String toFile = "/home/aleksei_khitev/test_8.txt";
        try (FileInputStream fileInputStream = new FileInputStream(fromFile);
             FileOutputStream fileOutputStream = new FileOutputStream(toFile);
             FileChannel inputChannel = fileInputStream.getChannel();
             FileChannel outputChannel = fileOutputStream.getChannel()) {
            inputChannel.transferTo(0, inputChannel.size(), outputChannel);
            // Эквивалентно: outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
