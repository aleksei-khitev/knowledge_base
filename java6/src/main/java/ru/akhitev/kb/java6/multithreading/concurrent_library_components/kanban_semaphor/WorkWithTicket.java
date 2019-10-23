package ru.akhitev.kb.java6.multithreading.concurrent_library_components.kanban_semaphor;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class WorkWithTicket implements Runnable {
    private final int key;
    private final Semaphore semaphore;

    WorkWithTicket(int key, Semaphore semaphore) {
        this.key = key;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("Took in progress " + toString());
            TimeUnit.MILLISECONDS.sleep(200);
            System.out.println("Resolved " + toString());
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() { return "Ticket{ key=" + key + '}'; }
}
