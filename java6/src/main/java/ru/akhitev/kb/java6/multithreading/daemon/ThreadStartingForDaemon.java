package ru.akhitev.kb.java6.multithreading.daemon;

import ru.akhitev.kb.java6.enum_examples.EnumOfEnums;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class ThreadStartingForDaemon {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RunnableForDaemon());
        thread.setDaemon(true);
        thread.start();
        TimeUnit.MILLISECONDS.sleep(100);
    }
}
