package ru.akhitev.kb.java6.multithreading.wait_notify.team;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class JiraBoard {
    private final Developer freeDeveloper;
    private final ProjectManager projectManager;
    private Ticket tickerInProgress;
    private int nextNumber;

    JiraBoard() {
        freeDeveloper = new Developer(this);
        projectManager = new ProjectManager(this);
        nextNumber = 1;
    }

    public static void main(String[] args) {
        JiraBoard jiraBoard = new JiraBoard();
        jiraBoard.startWork();
    }

    private void startWork() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(freeDeveloper);
        executorService.execute(projectManager);
    }

    Developer getFreeDeveloper() { return freeDeveloper; }

    ProjectManager getProjectManager() { return projectManager; }

    Ticket getTickerInProgress() { return tickerInProgress; }

    void finishTicketInProgress() { tickerInProgress = null; }

    void setTickerInProgress(Ticket tickerInProgress) { this.tickerInProgress = tickerInProgress; }

    int getAndIncrementNextNumber() { return nextNumber++; }
}
