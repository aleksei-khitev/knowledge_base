package ru.akhitev.kb.java6.multithreading.syncronized_and_lock;

import java.util.stream.IntStream;

public class SynchronizedSharedResource implements SharedResource {
    private int i;

    public synchronized int calculate(int first, int last) {
        IntStream.range(first, last).forEach(index -> {
            System.out.println("i = " + i + "; index = " + index);
            i += index;
            System.out.println("result = i = " + i);
        });
        return i;
    }
}
