package ru.akhitev.kb.java8.multithreading.wait_notify.team_multiple_queues;

import java.util.concurrent.BlockingQueue;

class QaEngineer implements Runnable {
    private final BlockingQueue<Ticket> queueForQa;

    QaEngineer(BlockingQueue<Ticket> queueForQa) {
        this.queueForQa = queueForQa;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Ticket ticket = queueForQa.take();
                ticket.setState(TicketState.ACCEPTED);
                System.out.println("Test complete for " + ticket);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
