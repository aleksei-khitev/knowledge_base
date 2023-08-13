package threads.completable_future.coordination;

import java.util.concurrent.CompletableFuture;

public class PreparingBookSynopsis {
    public static void main(String[] args) {
        CompletableFuture
                .runAsync(() -> System.out.println("Прочитать с заметками главу про коллекции"))
                .thenRun(() -> System.out.println("Законспектировать по заметками главу про коллекции"))
                .thenRun(() -> System.out.println("Прочитать с заметками главу про IO"))
                .thenRun(() -> System.out.println("Законспектировать по заметками главу про IO"))
                .thenRun(() -> System.out.println("Прочитать с заметками главу про многопоточность"))
                .thenRun(() -> System.out.println("Законспектировать по заметками главу про многопоточность"));
    }
}
