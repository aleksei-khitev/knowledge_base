package ru.akhitev.kb.java6.multithreading.wait_notify.team_multiple_queues;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

class Developer implements Runnable {
    private final BlockingQueue<Ticket> queueForDevelopment;
    private final BlockingQueue<Ticket> queueForQa;

    Developer(BlockingQueue<Ticket> queueForDevelopment, BlockingQueue<Ticket> queueForQa) {
        this.queueForDevelopment = queueForDevelopment;
        this.queueForQa = queueForQa;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Ticket ticket = queueForDevelopment.take();
                ticket.setState(TicketState.IN_PROGRESS);
                System.out.println("Development started for " + ticket);
                TimeUnit.MILLISECONDS.sleep(100);
                ticket.setState(TicketState.RESOLVED);
                System.out.println("Resolved " + ticket);
                queueForQa.add(ticket);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
