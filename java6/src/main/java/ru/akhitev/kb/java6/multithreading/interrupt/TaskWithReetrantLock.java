package ru.akhitev.kb.java6.multithreading.interrupt;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskWithReetrantLock implements Runnable {
    private final Lock lock;

    public TaskWithReetrantLock() {
        lock = new ReentrantLock();
        lock.lock();
    }

    @Override
    public void run() {
        System.out.println("waiting for operation");
        operation();
        System.out.println("Broken out of blocked call");
    }

    private void operation() {
        try {
            lock.lockInterruptibly();
            System.out.println("Lock accured in operation");
        } catch (InterruptedException e) {
            System.out.println("Interrupted in operation: " + e);
        }
    }
}
