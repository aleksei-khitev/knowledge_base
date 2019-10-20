package ru.akhitev.kb.java6.multithreading.exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

class ShipYard implements Runnable {
    private final Exchanger<Ship> exchanger;
    private int shipSerialNumber = 1;

    ShipYard(Exchanger<Ship> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Ship newShip = new Ship(shipSerialNumber++);
                TimeUnit.MILLISECONDS.sleep(100);
                exchanger.exchange(newShip);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
