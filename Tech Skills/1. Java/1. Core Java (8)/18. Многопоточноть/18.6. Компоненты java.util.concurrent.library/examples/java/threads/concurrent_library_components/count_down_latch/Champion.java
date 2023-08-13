package threads.concurrent_library_components.count_down_latch;

import java.util.concurrent.CountDownLatch;

public class Champion implements Runnable {
    private final CountDownLatch countDownLatch;

    public Champion(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("Champion: Waiting");
            countDownLatch.await();
            System.out.println("Champion: Fight!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
