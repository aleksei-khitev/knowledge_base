package ru.akhitev.kb.java6.multithreading.priority;

import java.time.chrono.MinguoDate;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ExecutorWithPriorities {
    public static void main(String[] args) {
        Executor executor = Executors.newCachedThreadPool();
        IntStream.range(Thread.MIN_PRIORITY, Thread.MAX_PRIORITY)
                .forEach(index -> executor.execute(new RunnableWithPriority(index)));
    }
}
