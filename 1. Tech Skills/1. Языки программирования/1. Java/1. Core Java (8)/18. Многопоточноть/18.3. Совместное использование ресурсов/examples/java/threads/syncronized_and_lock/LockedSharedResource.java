package threads.syncronized_and_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

class LockedSharedResource implements SharedResource {
    private Lock lock = new ReentrantLock();
    private int i;

    public int calculate(int first, int last) {
        lock.lock();
        try {
            IntStream.range(first, last).forEach(index -> {
                System.out.println("i = " + i + "; index = " + index);
                i += index;
                System.out.println("result = i = " + i);
            });
            return i;
        } finally {
            lock.unlock();
        }
    }
}
