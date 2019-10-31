package ru.akhitev.kb.java8.multithreading.thread_local;

class SomeRunnable implements Runnable {
    private SharedResource resource;
    private final int first;
    private final int last;

    SomeRunnable(SharedResource resource, int first, int last) {
        this.resource = resource;
        this.first = first;
        this.last = last;
    }

    @Override
    public void run() {
        System.out.println(resource.calculate(first, last));
    }
}
