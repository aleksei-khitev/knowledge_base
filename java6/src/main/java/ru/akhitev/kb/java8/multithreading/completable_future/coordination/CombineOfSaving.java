package ru.akhitev.kb.java8.multithreading.completable_future.coordination;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CombineOfSaving {
    public static void main(String[] args) {
        CompletableFuture<Boolean> save = CompletableFuture
                .supplyAsync(CombineOfSaving::saveToDb)
                .thenCombine(CompletableFuture.supplyAsync(CombineOfSaving::saveToBackUpQueue),
                        (saveToDb, saveToQueue) -> saveToDb && saveToQueue);
        System.out.println("Сохранение объектов в базу данных и резервную очередь прошло успешно? : "
                + save.join());
    }

    private static boolean saveToDb() {
        try {
            System.out.println("Начали сохранение в БД");
            TimeUnit.MILLISECONDS.sleep(200);
            System.out.println("Сохранение в БД успешно завершено");
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean saveToBackUpQueue() {
        try {
            System.out.println("Начали сохранение в резервную очередь");
            TimeUnit.MILLISECONDS.sleep(50);
            System.out.println("Сохранение в резервную очередь успешно завершено");
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
}
