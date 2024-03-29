package threads.producers_consumers.team_multiple_queues;

import java.util.concurrent.*;

public class Jira {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Ticket> queueForDevelopment = new LinkedBlockingQueue<>();
        BlockingQueue<Ticket> queueForQa = new LinkedBlockingQueue<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ProjectManager(queueForDevelopment));
        executorService.execute(new Developer(queueForDevelopment, queueForQa));
        executorService.execute(new QaEngineer(queueForQa));
        TimeUnit.SECONDS.sleep(2);
        executorService.shutdownNow();
    }
}
