package threads.interruption;

import java.util.concurrent.TimeUnit;

class SomeTask implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.err.println("Was interrupted: " + e.getMessage());
        }
    }
}
