package ru.akhitev.kb.java6.multithreading.concurrent_library_components.count_down_latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Raid {
    public static void main(String[] args) {
        // ждем агро танка, бафы/дебафы/контроль от рц и хм
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Hunter(countDownLatch));
        executorService.execute(new Champion(countDownLatch));
        executorService.execute(new Tank(countDownLatch));
        executorService.execute(new Captain(countDownLatch));
        executorService.execute(new LoreMaster(countDownLatch));
        executorService.shutdown();
    }
}
