package ru.akhitev.kb.java6.multithreading.priority;

import java.util.concurrent.TimeUnit;

public class RunnableWithPriority implements Runnable {
    private final int priority;

    public RunnableWithPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        System.out.println("Поток [" +
                Thread.currentThread().getId() + "] с приоритетом [" +
                priority + "]");
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Поток " + Thread.currentThread().getId() + " продолжен");
    }
}
