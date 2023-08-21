package threads.sleep;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SleepExample {
    public static void main(String[] args) {
        Executor executor = Executors.newCachedThreadPool();
        IntStream.range(0, 2).forEach(index -> executor.execute(new RunnableWithSleep()));
    }
}
