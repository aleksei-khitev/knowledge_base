package threads.concurrent_library_components.tasks_priority_queue;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import static threads.concurrent_library_components.tasks_priority_queue.TicketStatus.IN_PROGRESS;
import static threads.concurrent_library_components.tasks_priority_queue.TicketStatus.RESOLVED;

class Developer implements Runnable {
    private final PriorityBlockingQueue<Ticket> developmentQueue;
    private final PriorityBlockingQueue<Ticket> testingQueue;

    Developer(PriorityBlockingQueue<Ticket> developmentQueue, PriorityBlockingQueue<Ticket> testingQueue) {
        this.developmentQueue = developmentQueue;
        this.testingQueue = testingQueue;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                Ticket ticket = developmentQueue.take();
                ticket.setStatus(IN_PROGRESS);
                System.out.println("D: started working with " + ticket);
                TimeUnit.MILLISECONDS.sleep(200);
                ticket.setStatus(RESOLVED);
                System.out.println("D: fixed " + ticket);
                testingQueue.add(ticket);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
