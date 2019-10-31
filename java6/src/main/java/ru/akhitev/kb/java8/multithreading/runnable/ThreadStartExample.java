package ru.akhitev.kb.java8.multithreading.runnable;

public class ThreadStartExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new SimpleRunnable());
        thread.start();
        System.out.println("Main method is waiting for all iterations in SimpleRunnable");
    }
}
