package threads.producers_consumers.team;

class Developer implements Runnable {
    private final JiraBoard jiraBoard;

    Developer(JiraBoard jiraBoard) {
        this.jiraBoard = jiraBoard;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized (this) {
                    while (jiraBoard.getTickerInProgress() == null) {
                        wait();
                    }
                }
                System.out.println("Developer взял задачу " + jiraBoard.getTickerInProgress());
                synchronized (jiraBoard.getProjectManager()) {
                    jiraBoard.finishTicketInProgress();
                    jiraBoard.getProjectManager().notifyAll();
                }
            }
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
