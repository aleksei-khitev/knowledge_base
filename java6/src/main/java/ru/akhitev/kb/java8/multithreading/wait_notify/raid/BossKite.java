package ru.akhitev.kb.java8.multithreading.wait_notify.raid;

import java.util.concurrent.TimeUnit;

class BossKite implements Runnable {
    private TacticForBoss tacticForBoss;

    BossKite(TacticForBoss tacticForBoss) {
        this.tacticForBoss = tacticForBoss;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                tacticForBoss.waitForOathBreakersShame();
                System.out.println("Кайтим, пока не будет клятвы");
                TimeUnit.MILLISECONDS.sleep(100);
                tacticForBoss.oathBreakersShameEnded();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
