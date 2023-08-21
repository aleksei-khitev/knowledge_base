package threads.raid;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RaidToBoss {
    public static void main(String[] args) throws InterruptedException {
        //TacticForBoss tacticForBoss = getWithWaitAndNotify();
        TacticForBoss tacticForBoss = getWithLockAndCondition();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new BossKite(tacticForBoss));
        executorService.execute(new BossAssail(tacticForBoss));
        TimeUnit.SECONDS.sleep(2);
        executorService.shutdownNow();
    }

    private static TacticForBoss getWithWaitAndNotify() {
        return new TacticForBossWithWaitNotify();
    }

    private static TacticForBoss getWithLockAndCondition() {
        return new TacticForBossWithConditionAndLock();
    }
}
