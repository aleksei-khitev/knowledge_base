package ru.akhitev.kb.java8.multithreading;

import ru.akhitev.kb.java8.multithreading.runnable.SimpleRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ExecutorShutdown {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        IntStream.range(0, 2).forEach(index -> executorService.execute(new SimpleRunnable()));
        executorService.shutdown();
        executorService.execute(new SimpleRunnable());
        executorService.execute(new SimpleRunnable());
        System.out.println("The end of main");
    }
}
