package ru.akhitev.kb.java6.multithreading.wait_notify.team_queue;

import ru.akhitev.kb.java6.multithreading.wait_notify.team.Ticket;

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
