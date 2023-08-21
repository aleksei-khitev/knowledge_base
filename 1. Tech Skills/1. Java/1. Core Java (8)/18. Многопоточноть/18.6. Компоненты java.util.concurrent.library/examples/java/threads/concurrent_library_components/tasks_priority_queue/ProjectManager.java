package threads.concurrent_library_components.tasks_priority_queue;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import static threads.concurrent_library_components.tasks_priority_queue.TicketPriority.*;

class ProjectManager implements Runnable {
    private final PriorityBlockingQueue<Ticket> developmentQueue;

    ProjectManager(PriorityBlockingQueue<Ticket> developmentQueue) {
        this.developmentQueue = developmentQueue;
    }

    @Override
    public void run() {
        try {
            Ticket ticket1 = new Ticket(1, "Repair emailing", HIGH);
            System.out.println("PM: opened " + ticket1);
            developmentQueue.add(ticket1);
            TimeUnit.MILLISECONDS.sleep(200);
            Ticket ticket2 = new Ticket(2, "Change label", LOW);
            System.out.println("PM: opened " + ticket2);
            developmentQueue.add(ticket2);
            TimeUnit.MILLISECONDS.sleep(200);
            Ticket ticket3 = new Ticket(3, "Fix memory issue", BLOCKER);
            System.out.println("PM: opened " + ticket3);
            developmentQueue.add(ticket3);
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
