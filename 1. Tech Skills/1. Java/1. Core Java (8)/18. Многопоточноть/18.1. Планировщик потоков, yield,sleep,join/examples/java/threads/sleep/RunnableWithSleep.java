package threads.sleep;

import java.util.concurrent.TimeUnit;

class RunnableWithSleep implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + " started working");
        try {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getId() + " проснулся после Thread.sleep()");
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println(Thread.currentThread().getId() + " проснулся после TimeUnit.MILLISECONDS.sleep()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
