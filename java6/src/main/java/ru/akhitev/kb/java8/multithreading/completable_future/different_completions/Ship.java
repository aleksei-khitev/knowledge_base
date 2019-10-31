package ru.akhitev.kb.java8.multithreading.completable_future.different_completions;

class Ship {
    private final String name;
    private int hull;

    Ship(String name) { this.name = name; }

    int getHull() { return hull; }

    void setHull(int hull) { this.hull = hull; }

    @Override
    public String toString() {
        return "Ship{name='" + name + "', hull=" + hull + '}';
    }
}
