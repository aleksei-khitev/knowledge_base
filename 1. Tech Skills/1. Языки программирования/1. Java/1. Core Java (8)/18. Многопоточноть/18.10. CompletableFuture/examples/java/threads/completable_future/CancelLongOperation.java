package threads.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CancelLongOperation {
    public static void main(String[] args) {
        CompletableFuture<String> lineFromTooSlowSource = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Long wawited line";
        });
        lineFromTooSlowSource.cancel(true);
        lineFromTooSlowSource.join();
    }
}
