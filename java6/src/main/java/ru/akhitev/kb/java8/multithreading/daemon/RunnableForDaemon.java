package ru.akhitev.kb.java8.multithreading.daemon;

class RunnableForDaemon implements Runnable {
    @Override
    public void run() {
        System.out.println("daemon is working");
    }
}
