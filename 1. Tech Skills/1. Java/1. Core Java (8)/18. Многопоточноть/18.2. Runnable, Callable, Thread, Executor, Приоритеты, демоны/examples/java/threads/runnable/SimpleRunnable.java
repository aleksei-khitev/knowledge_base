package threads.runnable;

import java.util.stream.IntStream;

public class SimpleRunnable implements Runnable {
    @Override
    public void run() {
        IntStream.range(0, 5).forEach(index -> {
            System.out.println(Thread.currentThread().getId() + ": current iteration is: " + index);
            Thread.yield();
        });
    }
}
