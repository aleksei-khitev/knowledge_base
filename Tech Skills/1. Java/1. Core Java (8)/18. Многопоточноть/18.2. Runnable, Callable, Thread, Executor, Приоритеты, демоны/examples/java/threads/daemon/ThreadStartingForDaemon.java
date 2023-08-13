package threads.daemon;

import java.util.concurrent.TimeUnit;

public class ThreadStartingForDaemon {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RunnableForDaemon());
        thread.setDaemon(true);
        thread.start();
        TimeUnit.MILLISECONDS.sleep(100);
    }
}
