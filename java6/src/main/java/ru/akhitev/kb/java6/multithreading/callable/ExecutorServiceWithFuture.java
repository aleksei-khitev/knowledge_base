package ru.akhitev.kb.java6.multithreading.callable;

import ru.akhitev.kb.java6.multithreading.callable.SimpleCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceWithFuture {
    private static List<Future<String>> results;

    public static void main(String[] args) {
        results = new ArrayList<>();
        submitCallables();
        printCallableResults();
    }

    private static void submitCallables() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            Future<String> result = executor.submit(new SimpleCallable());
            results.add(result);
        }
    }

    private static void printCallableResults() {
        for (Future<String> result : results) {
            try {
                System.out.println(result.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
