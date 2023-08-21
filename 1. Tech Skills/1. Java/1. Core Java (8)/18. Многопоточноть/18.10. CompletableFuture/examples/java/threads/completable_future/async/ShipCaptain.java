package threads.completable_future.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ShipCaptain {

    public static void main(String[] args) {
        prepareAndSendStatusReport();
        CompletableFuture<String> replyToQuery = queryForInformation("Где последний раз был замечен противник в районе xyz?");
        System.out.println(replyToQuery.join());
    }

    static void prepareAndSendStatusReport() {
        CompletableFuture.runAsync(()-> {
            System.out.println("Начали отправку текущего статуса корабля");
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Отправка текущего статуса корабля окончена");
        });
    }

    static CompletableFuture<String> queryForInformation(String query) {
        return CompletableFuture.supplyAsync(()-> {
            System.out.println("Начали отправку запроса: " + query);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("По запросу [" + query + "] получен ответ");
            return "Ответ на запрос: " + query;
        });
    }
}
