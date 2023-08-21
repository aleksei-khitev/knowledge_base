package threads.thread_local;

import java.util.stream.IntStream;

class SharedResource {
    private static ThreadLocal<Integer> i;

    static {
        i = new ThreadLocal<>();
    }

    int calculate(int first, int last) {
        i.set(0);
        IntStream.range(first, last).forEach(index -> {
            System.out.println("i = " + i + "; index = " + index);
            i.set(i.get() + index);
            System.out.println("result = i = " + i.get());
        });
        return i.get();
    }
}
