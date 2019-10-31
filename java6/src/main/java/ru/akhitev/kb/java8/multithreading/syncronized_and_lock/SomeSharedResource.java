package ru.akhitev.kb.java8.multithreading.syncronized_and_lock;

import java.util.stream.IntStream;

class SomeSharedResource implements SharedResource {
    private int i;

    /** Небезопасный метод, используется 3 потоками */
    public int calculate(int first, int last) {
        IntStream.range(first, last).forEach( index -> {
            System.out.println("i = " + i + "; index = " + index);
            i += index;
            System.out.println("result = i = " + i);
        });
        return i;
    }
}
