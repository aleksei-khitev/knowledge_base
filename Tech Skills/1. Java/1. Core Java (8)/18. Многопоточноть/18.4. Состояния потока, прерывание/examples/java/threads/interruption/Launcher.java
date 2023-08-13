package threads.interruption;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Launcher {
    public static void main(String[] args) throws InterruptedException, IOException {
        //interruptViaThreadInterrupt();
        //interruptViaExecutorShutDownNow();
        //interruptViaFutureCancel();
        //interruptRunnableWaitingForSync();
        //interruptRunnableWaitingForIO();
        //interruptChannel();
        //closeChannel();
        interruptLock();
    }

    private static void interruptViaThreadInterrupt() {
        Thread thread = new Thread(new SomeTask());
        thread.start();
        thread.interrupt();
    }

    private static void interruptViaExecutorShutDownNow() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        IntStream.range(0, 2).forEach(index -> executorService.execute(new SomeTask()));
        executorService.shutdownNow();
    }

    private static void interruptViaFutureCancel() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> future = executorService.submit(new SomeTask());
        future.cancel(true);
    }

    private static void interruptRunnableWaitingForSync() throws InterruptedException {
        interruptWithExitOnCoolDown(new WaitingForSynchronizedBlockTask());
    }

    private static void interruptRunnableWaitingForIO() throws InterruptedException {
        interruptWithExitOnCoolDown(new WaitingForIoTask());
    }

    private static void interruptWithExitOnCoolDown(Runnable runnable) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(runnable);
        executorService.shutdownNow();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Вырубаем приложение, так как задача не может завершиться");
        System.exit(0);
    }

    private static void interruptChannel() throws IOException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new TaskWithNio(prepareSocketChannel()));
        TimeUnit.SECONDS.sleep(1);
        executorService.shutdownNow();
    }

    private static void closeChannel() throws IOException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        SocketChannel channel = prepareSocketChannel();
        executorService.execute(new TaskWithNio(channel));
        TimeUnit.SECONDS.sleep(1);
        channel.close();
    }

    private static SocketChannel prepareSocketChannel() throws IOException {
        ServerSocket socket = new ServerSocket(9092);
        InetSocketAddress address = new InetSocketAddress("localhost", 9092);
        return SocketChannel.open(address);
    }

    private static void interruptLock() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new TaskWithReetrantLock());
        TimeUnit.SECONDS.sleep(1);
        executorService.shutdownNow();
    }
}
