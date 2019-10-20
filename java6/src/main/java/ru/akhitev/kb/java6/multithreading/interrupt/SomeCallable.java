package ru.akhitev.kb.java6.multithreading.interrupt;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class SomeCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.err.println("Was interrupted: " + e.getMessage());
        }
        return null;
    }
}
