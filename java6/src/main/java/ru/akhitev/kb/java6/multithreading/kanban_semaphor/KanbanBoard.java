package ru.akhitev.kb.java6.multithreading.kanban_semaphor;

import ru.akhitev.kb.java6.multithreading.wait_notify.team.Ticket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class KanbanBoard {
    private static final int wipLimit = 3;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(wipLimit);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=1; i<= 10; i++) {
            WorkWithTicket workWithTicket = new WorkWithTicket(i, semaphore);
            System.out.println("Заведен " + workWithTicket);
            executorService.execute(workWithTicket);
        }
        executorService.shutdown();
    }
}
