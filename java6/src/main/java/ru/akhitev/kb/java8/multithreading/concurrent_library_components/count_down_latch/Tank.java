package ru.akhitev.kb.java8.multithreading.concurrent_library_components.count_down_latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class Tank implements Runnable {
    private final CountDownLatch countDownLatch;

    Tank(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("Tank: generating agro");
            TimeUnit.MILLISECONDS.sleep(100);
            countDownLatch.countDown();
            System.out.println("Tank: Ok, Boss and adds on me");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
