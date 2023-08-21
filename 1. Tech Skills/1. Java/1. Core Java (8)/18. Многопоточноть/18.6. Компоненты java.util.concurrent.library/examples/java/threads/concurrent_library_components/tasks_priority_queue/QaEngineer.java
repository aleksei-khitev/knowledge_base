package threads.concurrent_library_components.tasks_priority_queue;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import static threads.concurrent_library_components.tasks_priority_queue.TicketStatus.ACCEPTED;

class QaEngineer implements Runnable {
    private final PriorityBlockingQueue<Ticket> testingQueue;

    QaEngineer(PriorityBlockingQueue<Ticket> testingQueue) {
        this.testingQueue = testingQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Ticket ticket = testingQueue.take();
                System.out.println("QA: started verification of " + ticket);
                TimeUnit.MILLISECONDS.sleep(200);
                ticket.setStatus(ACCEPTED);
                System.out.println("QA: closed " + ticket);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
