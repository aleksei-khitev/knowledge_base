package threads.interruption;

import java.util.concurrent.TimeUnit;

public class TaskWithInterrupted implements Runnable {
    @Override
    public void run() {
        while(!Thread.interrupted()) {
            System.out.println("Sleeping");
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("");
    }
}
