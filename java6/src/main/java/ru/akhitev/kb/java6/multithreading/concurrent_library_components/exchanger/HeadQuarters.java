package ru.akhitev.kb.java6.multithreading.concurrent_library_components.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class HeadQuarters {
    public static void main(String[] args) throws InterruptedException {
        Exchanger<Ship> exchanger = new Exchanger<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ShipYard(exchanger));
        executorService.execute(new Fleet(exchanger));
        TimeUnit.SECONDS.sleep(2);
        executorService.shutdownNow();
    }
}
