package threads.raid;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TacticForBossWithConditionAndLock implements TacticForBoss {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean oathBreakersShameActive = false;

    public void startOathBreakersShame() {
        lock.lock();
        try {
            oathBreakersShameActive = true;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void oathBreakersShameEnded() {
        lock.lock();
        try {
            oathBreakersShameActive = false;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void waitForOathBreakersShame() throws InterruptedException {
        lock.lock();
        try {
            while (!oathBreakersShameActive) {
                condition.await();
            }
        } finally {
            lock.unlock();
        }
    }

    public void fullDamage() throws InterruptedException {
        lock.lock();
        try {
            while (oathBreakersShameActive) {
                condition.await();
            }
        } finally {
            lock.unlock();
        }
    }
}
