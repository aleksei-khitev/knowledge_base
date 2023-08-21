package threads.producers_consumers.team_queue;

import threads.producers_consumers.team.Ticket;

import java.util.concurrent.*;

class Board {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Ticket> queue = new LinkedBlockingQueue<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Developer(queue));
        executorService.execute(new QaEngineer(queue));
        TimeUnit.SECONDS.sleep(2);
        executorService.shutdownNow();
    }
}
