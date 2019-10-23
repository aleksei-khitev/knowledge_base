package ru.akhitev.kb.java6.multithreading.concurrent_library_components.tasks_priority_queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Team {
    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Ticket> developmentQueue = new PriorityBlockingQueue<>();
        PriorityBlockingQueue<Ticket> testingQueue = new PriorityBlockingQueue<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ProjectManager(developmentQueue));
        TimeUnit.SECONDS.sleep(3);
        executorService.execute(new Developer(developmentQueue, testingQueue));
        executorService.execute(new QaEngineer(testingQueue));
        executorService.shutdown();
    }
}
