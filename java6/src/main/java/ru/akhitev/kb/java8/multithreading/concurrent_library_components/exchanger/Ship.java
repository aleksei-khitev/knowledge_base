package ru.akhitev.kb.java8.multithreading.concurrent_library_components.exchanger;

class Ship {
    private final int shipSerialNumber;

    Ship(int shipSerialNumber) {
        this.shipSerialNumber = shipSerialNumber;
    }

    @Override
    public String toString() { return "Ship{shipSerialNumber=" + shipSerialNumber + '}'; }
}
