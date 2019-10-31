package ru.akhitev.kb.java8.io.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {
    public static void main(String[] args) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("/home/aleksei_khitev/test_3.txt");
             FileChannel fileChannel = fileOutputStream.getChannel();
             FileLock fileLock = fileChannel.tryLock()) {
            if (fileLock != null) {
                System.out.println("Locked File");
                TimeUnit.MILLISECONDS.sleep(100);
                fileLock.release();
                System.out.println("Released Lock");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
