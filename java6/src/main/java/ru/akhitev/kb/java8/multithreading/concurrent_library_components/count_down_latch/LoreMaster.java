package ru.akhitev.kb.java8.multithreading.concurrent_library_components.count_down_latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class LoreMaster implements Runnable {
    private final CountDownLatch countDownLatch;

    public LoreMaster(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("Lore Master: debuffing");
            System.out.println("Lore Master: buffing");
            System.out.println("Lore Master: controlling");
            TimeUnit.MILLISECONDS.sleep(100);
            countDownLatch.countDown();
            System.out.println("Lore Master: I've finished!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
