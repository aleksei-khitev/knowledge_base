package ru.akhitev.kb.java6.multithreading.delay_queue;

import java.util.Comparator;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedTask implements Delayed {
    private final int id;
    private long startTime;

    DelayedTask(int id, long startTime) {
        this.id = id;
        this.startTime = startTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long diff = startTime - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Comparator
                .comparingLong(DelayedTask::getStartTime)
                .compare(this, ( DelayedTask) o);
    }

    long getStartTime() {
        return startTime;
    }

    @Override
    public String toString() { return "DelayedTask{ id=" + id + ", startTime=" + startTime + '}'; }
}
