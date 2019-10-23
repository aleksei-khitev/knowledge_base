package ru.akhitev.kb.java6.multithreading.completable_future.different_completions;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Fleet {
    private static ShipRepairYard repairYard = new ShipRepairYard();

    public static void main(String[] args) {
        sendRepairableShip();
        sendUnRepairableShip();
        sendShipWithNoNeedInRepair();
    }

    private static void sendAndWaitShip(Ship ship) {
        try {
            CompletableFuture<Ship> repairedShip = repairYard.repairShip(ship);
            System.out.println("С верфей вернулся " + repairedShip.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void sendRepairableShip() {
        Ship ship = new Ship("Стойкий");
        ship.setHull(50);
        sendAndWaitShip(ship);
    }

    private static void sendUnRepairableShip() {
        Ship ship = new Ship("Героический");
        ship.setHull(12);
        sendAndWaitShip(ship);
    }

    private static void sendShipWithNoNeedInRepair() {
        Ship ship = new Ship("Молненосный");
        ship.setHull(94);
        sendAndWaitShip(ship);
    }
}
