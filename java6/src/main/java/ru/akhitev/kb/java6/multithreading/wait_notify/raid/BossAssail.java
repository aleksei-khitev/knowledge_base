package ru.akhitev.kb.java6.multithreading.wait_notify.raid;

import java.util.concurrent.TimeUnit;

class BossAssail implements Runnable {
    private TacticForBoss tacticForBoss;

    BossAssail(TacticForBoss tacticForBoss) {
        this.tacticForBoss = tacticForBoss;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Клятва пошла");
                TimeUnit.MILLISECONDS.sleep(100);
                tacticForBoss.startOathBreakersShame();
                System.out.println("Пошел дамаг");
                tacticForBoss.fullDamage();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
