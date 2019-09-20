package ru.akhitev.kb.java6.multithreading.join;

public class Joiner extends Thread {
    private Thread sleeper;

    public Joiner(Thread sleeper) {
        this.sleeper = sleeper;
    }

    @Override
    public void run() {
        try {
            System.out.println(getId() + "(Joiner) начал работу");
            sleeper.join();
            System.out.println(getId() + "(Joiner) окончил работу");
        } catch (InterruptedException e) {
            System.out.println(getId() + "(Joiner) был прерван");
        }
    }
}
