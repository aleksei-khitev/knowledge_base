package ru.akhitev.kb.java8.multithreading.concurrent_library_components.cyclic_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Participant implements Runnable {
    private final int number;
    private final CyclicBarrier barrier;

    Participant(int number, CyclicBarrier barrier) {
        this.number = number;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(number + ": готов к старту.");
            barrier.await();
            System.out.println(number + ": побежал!");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
