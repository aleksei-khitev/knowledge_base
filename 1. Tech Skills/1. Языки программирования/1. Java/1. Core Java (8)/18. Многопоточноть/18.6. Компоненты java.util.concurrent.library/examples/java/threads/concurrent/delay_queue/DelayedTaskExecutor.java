package threads.concurrent_library_components.delay_queue;

import java.util.concurrent.DelayQueue;

class DelayedTaskExecutor implements Runnable {
    private final DelayQueue<DelayedTask> queue;

    DelayedTaskExecutor(DelayQueue<DelayedTask> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                DelayedTask task = queue.take();
                System.out.println("Выполнена задача " + task);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
