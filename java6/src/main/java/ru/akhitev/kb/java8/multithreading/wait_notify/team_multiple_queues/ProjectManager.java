package ru.akhitev.kb.java8.multithreading.wait_notify.team_multiple_queues;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

class ProjectManager implements Runnable {
    private final BlockingQueue<Ticket> queueForDevelopment;
    private int nextKey = 1;

    ProjectManager(BlockingQueue<Ticket> queueForDevelopment) {
        this.queueForDevelopment = queueForDevelopment;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Ticket ticket = new Ticket(nextKey++);
                System.out.println("Opened " + ticket);
                queueForDevelopment.add(ticket);
                TimeUnit.MILLISECONDS.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
