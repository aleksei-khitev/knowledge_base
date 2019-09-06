package ru.akhitev.kb.java6.io.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.stream.IntStream;

public class LargeFileMapping {
    public static void main(String[] args) {
        try (RandomAccessFile outputFile = new RandomAccessFile("/home/aleksei_khitev/test_9.txt", "rw");
             FileChannel outputFileChannel = outputFile.getChannel()) {
            int length = 0x8FFFFFF; // 128 MB
            MappedByteBuffer outputBuffer = outputFileChannel.map(FileChannel.MapMode.READ_WRITE, 0, length);
            IntStream.range(0, length).forEach(index -> outputBuffer.put((byte) 'x'));
            System.out.println("Finish writing");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
