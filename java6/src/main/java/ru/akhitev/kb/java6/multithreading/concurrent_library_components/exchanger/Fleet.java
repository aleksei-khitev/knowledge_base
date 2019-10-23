package ru.akhitev.kb.java6.multithreading.concurrent_library_components.exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

class Fleet implements Runnable {
    private final Exchanger<Ship> exchanger;
    private final List<Ship> ships;

    Fleet(Exchanger<Ship> exchanger) {
        this.exchanger = exchanger;
        this.ships = new ArrayList<>();
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Ship ship = exchanger.exchange(null);
                ships.add(ship);
                System.out.println("Fleet elements: " + ships);
                System.out.println("Fleet moved to an operation");
                TimeUnit.MILLISECONDS.sleep(50);
                System.out.println("Fleet returned");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
