package ru.akhitev.kb.java6.multithreading.callable;

import java.util.concurrent.Callable;

class SimpleCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Результат потока " + Thread.currentThread().getId();
    }
}
