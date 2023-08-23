package threads.interruption;

class WaitingForSynchronizedBlockTask implements Runnable {
    public WaitingForSynchronizedBlockTask() {
        System.out.println("Блокируем синхронизированный блок");
        new Thread(this::syncBlock).start();
    }

    @Override
    public void run() {
        System.out.println("Пытаемся войти в синхронизированный блок");
        syncBlock();
        System.out.println("Синхронизированный блок выполнен");
    }

    private synchronized void syncBlock() {
        while(true) {
            Thread.yield();
        }
    }
}
