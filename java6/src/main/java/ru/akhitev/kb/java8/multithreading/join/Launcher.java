package ru.akhitev.kb.java8.multithreading.join;

public class Launcher {
    public static void main(String[] args) {
        Thread sleeper = new Sleeper();
        Thread joiner = new Joiner(sleeper);
        sleeper.start();
        joiner.start();
        sleeper.interrupt();
    }
}
