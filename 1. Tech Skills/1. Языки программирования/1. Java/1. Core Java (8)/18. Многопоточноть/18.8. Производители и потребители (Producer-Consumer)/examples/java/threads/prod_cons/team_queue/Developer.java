package threads.producers_consumers.team_queue;

import threads.producers_consumers.team.Ticket;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

class Developer implements Runnable {
    private final BlockingQueue<Ticket> queue;
    private int ticketKey;

    Developer(BlockingQueue<Ticket> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                Ticket ticket = new Ticket(ticketKey++);
                queue.add(ticket);
                System.out.println("Resolved " + ticket);
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
