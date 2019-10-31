package ru.akhitev.kb.java8.multithreading.concurrent_library_components.delay_queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QueueLauncher {
    public static void main(String[] args) {
        DelayQueue<DelayedTask> queue = new DelayQueue<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new DelayedTaskExecutor(queue));
        queue.add(new DelayedTask(3, 100));
        queue.add(new DelayedTask(1, 70));
        queue.add(new DelayedTask(4, 110));
        executorService.shutdown();
    }
}
