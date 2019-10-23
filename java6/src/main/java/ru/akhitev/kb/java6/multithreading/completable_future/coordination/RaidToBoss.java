package ru.akhitev.kb.java6.multithreading.completable_future.coordination;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

class RaidToBoss {
    public static void main(String[] args) {
        CompletableFuture agro = CompletableFuture.runAsync(RaidToBoss::agro);
        CompletableFuture buff = CompletableFuture.runAsync(RaidToBoss::buff);
        CompletableFuture deBuff = CompletableFuture.runAsync(RaidToBoss::deBuff);
        CompletableFuture.allOf(agro, buff, deBuff);
        CompletableFuture<Boolean> isBossDefeated = CompletableFuture.runAsync(RaidToBoss::attack)
                .thenApply((attackResult) -> defeatBoss());
        System.out.println("Босс повержен " + isBossDefeated.join());
    }

    private static void agro() {
        System.out.println("Такни начали агрить");
        try { TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("Все сидят на танках");
    }

    private static void buff() {
        System.out.println("Рыцари, менсы и прочие начали бафать");
        try { TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("Рейд пробаффан");
    }

    private static void deBuff() {
        System.out.println("ХМы, бурги и прочие начали дебафать");
        try { TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("Противники отдебаффаны");
    }

    private static void attack() { System.out.println("Рейд пошел в атаку"); }

    private static boolean defeatBoss() { return true; }
}
