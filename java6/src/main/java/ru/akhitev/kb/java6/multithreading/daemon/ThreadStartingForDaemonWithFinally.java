package ru.akhitev.kb.java6.multithreading.daemon;

import java.util.concurrent.TimeUnit;

public class ThreadStartingForDaemonWithFinally {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RunnableForDaemonWithFinally());
        thread.setDaemon(true);
        thread.start();
        TimeUnit.MILLISECONDS.sleep(10);
    }
}
