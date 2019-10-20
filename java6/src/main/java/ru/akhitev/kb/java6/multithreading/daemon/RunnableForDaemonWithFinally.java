package ru.akhitev.kb.java6.multithreading.daemon;

import java.util.concurrent.TimeUnit;

class RunnableForDaemonWithFinally implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Processing daemon");
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }
}
