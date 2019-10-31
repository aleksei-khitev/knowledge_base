package ru.akhitev.kb.java8.multithreading.wait_notify.team;

import java.util.concurrent.TimeUnit;

class ProjectManager implements Runnable {
    private final JiraBoard jiraBoard;

    ProjectManager(JiraBoard jiraBoard) {
        this.jiraBoard = jiraBoard;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized (this) {
                    while (jiraBoard.getTickerInProgress() != null) {
                        wait(); // ждет, пока не закроется задача
                    }
                }
                System.out.println("PM создает тикет");
                synchronized (jiraBoard.getFreeDeveloper()) {
                    jiraBoard.setTickerInProgress(
                            new Ticket(jiraBoard.getAndIncrementNextNumber()));
                    jiraBoard.getFreeDeveloper().notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
