package ru.akhitev.kb.java6.multithreading.concurrent_library_components.cyclic_barrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HeroRace {
    private static final int SQUAD_MEMBER_COUNT = 5;
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = prepareCyclicBarrier();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i<10; i++) {
            executorService.execute(new Participant(i, barrier));
            TimeUnit.MILLISECONDS.sleep(50);
        }
        executorService.shutdown();
    }

    private static CyclicBarrier prepareCyclicBarrier() {
        return new CyclicBarrier(SQUAD_MEMBER_COUNT, ()-> {
            System.out.println("На старт!");
            System.out.println("Внимание!");
            System.out.println("Марш!");
        });
    }
}
