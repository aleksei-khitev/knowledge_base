package ru.akhitev.kb.java6.multithreading.runnable;

import ru.akhitev.kb.java6.multithreading.runnable.SimpleRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        IntStream.range(0, 3).forEach(index -> executorService.execute(new SimpleRunnable()));
    }
}
