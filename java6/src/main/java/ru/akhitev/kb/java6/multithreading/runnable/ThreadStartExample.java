package ru.akhitev.kb.java6.multithreading.runnable;

import ru.akhitev.kb.java6.multithreading.runnable.SimpleRunnable;

public class ThreadStartExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new SimpleRunnable());
        thread.start();
        System.out.println("Main method is waiting for all iterations in SimpleRunnable");
    }
}
