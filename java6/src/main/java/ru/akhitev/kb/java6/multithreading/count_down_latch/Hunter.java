package ru.akhitev.kb.java6.multithreading.count_down_latch;

import java.util.concurrent.CountDownLatch;

public class Hunter implements Runnable {
    private final CountDownLatch countDownLatch;

    public Hunter(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("Hunter: Waiting");
            countDownLatch.await();
            System.out.println("Hunter: Fight!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
