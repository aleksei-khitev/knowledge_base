package ru.akhitev.kb.java8.multithreading.wait_notify.team_queue;

import ru.akhitev.kb.java8.multithreading.wait_notify.team.Ticket;

import java.util.concurrent.BlockingQueue;

class QaEngineer implements Runnable {
    private final BlockingQueue<Ticket> queue;

    QaEngineer(BlockingQueue<Ticket> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Ticket ticket = queue.take();
                System.out.println("accepted " + ticket);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
