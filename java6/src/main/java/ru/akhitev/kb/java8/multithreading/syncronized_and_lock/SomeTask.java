package ru.akhitev.kb.java8.multithreading.syncronized_and_lock;

class SomeTask implements Runnable {
    private SharedResource resource;
    private int first;
    private int last;

    SomeTask(SharedResource resource, int first, int last) {
        this.resource = resource;
        this.first = first;
        this.last = last;
    }

    @Override
    public void run() {
        System.out.println(resource.calculate(first, last));
    }
}
