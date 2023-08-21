package threads.completable_future.different_completions;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

class ShipRepairYard {
    private static final int REPAIRABLE_HULL_LIMIT = 15;
    private static final int REPAIR_HULL_NOT_NEED_LIMIT = 80;

    CompletableFuture<Ship> repairShip(Ship ship) {
        CompletableFuture<Ship> completableFuture = new CompletableFuture<>();
        if (ship.getHull() <= REPAIRABLE_HULL_LIMIT) {
            completableFuture = unRepairable(ship);
        } else if (ship.getHull() >= REPAIR_HULL_NOT_NEED_LIMIT) {
            completableFuture = noNeedToRepair(ship);
        } else {
            completableFuture = repair(ship);
        }
        return completableFuture;
    }

    /** Вставляем исключение в CompletableFuture. Потом ловится как ExecutionException */
    private CompletableFuture<Ship> unRepairable(Ship ship) {
        CompletableFuture<Ship> completableFuture = new CompletableFuture<>();
        completableFuture.completeExceptionally(
                new RuntimeException(ship + " не поддается починка", null));
        return completableFuture;
    }

    /** Создаем на основе уже выислинного значения */
    private CompletableFuture<Ship> noNeedToRepair(Ship ship) {
        System.out.println(ship + " не нуждается в ремонте на верфи");
        return CompletableFuture.completedFuture(ship);
    }

    /** Записываем в существующий CompletableFuture */
    private CompletableFuture<Ship> repair(Ship ship) {
        CompletableFuture<Ship> completableFuture = new CompletableFuture<>();
        System.out.println("Начало ремонта " + ship);
        try { TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) { e.printStackTrace(); }
        ship.setHull(100);
        completableFuture.complete(ship);
        return completableFuture;
    }
}
