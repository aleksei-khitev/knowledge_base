package ru.akhitev.kb.java8.multithreading.syncronized_and_lock;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Launcher {
    public static void main(String[] args) {
        Executor executor = Executors.newCachedThreadPool();
        //SharedResource resource = getSimpleSharedResource();
        //SharedResource resource = getSynchronizedSharedResource();
        SharedResource resource = getLockedSharedResource();
        executor.execute(new SomeTask(resource, 1, 3));
        executor.execute(new SomeTask(resource, 4, 6));
        executor.execute(new SomeTask(resource, 7, 9));
    }

    static SharedResource getLockedSharedResource() {
        return new LockedSharedResource();
    }

    static SharedResource getSimpleSharedResource() {
        return new SomeSharedResource();
    }

    static SharedResource getSynchronizedSharedResource() {
        return new SynchronizedSharedResource();
    }
}
