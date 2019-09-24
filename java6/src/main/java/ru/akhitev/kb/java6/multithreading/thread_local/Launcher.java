package ru.akhitev.kb.java6.multithreading.thread_local;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Launcher {
    public static void main(String[] args) {
        Executor executor = Executors.newCachedThreadPool();
        SharedResource resource = new SharedResource();
        executor.execute(new SomeRunnable(resource, 1, 3));
        executor.execute(new SomeRunnable(resource, 4, 6));
        executor.execute(new SomeRunnable(resource, 7, 9));
    }
}
