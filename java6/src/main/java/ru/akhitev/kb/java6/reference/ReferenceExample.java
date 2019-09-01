package ru.akhitev.kb.java6.reference;

import java.lang.ref.*;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class ReferenceExample {
    private static ReferenceQueue<VeryBig> referenceQueue = new ReferenceQueue<>();
    public static void main(String[] args) {
        softReferenceExample();
        weakReferenceExample();
        System.gc();
        phantomReferenceExample();
    }

    private static void softReferenceExample() {
        LinkedList<SoftReference<VeryBig>> softReferences = new LinkedList<>();
        IntStream.range(0, 10).forEach(i -> {
            softReferences.add(new SoftReference<>(new VeryBig("Soft " + i)));
            System.out.println("Just created: " + softReferences.getLast().get());
            checkQueue();
        });
    }

    private static void weakReferenceExample() {
        LinkedList<WeakReference<VeryBig>> softReferences = new LinkedList<>();
        IntStream.range(0, 10).forEach(i -> {
            softReferences.add(new WeakReference<>(new VeryBig("Weak " + i)));
            System.out.println("Just created: " + softReferences.getLast().get());
            checkQueue();
        });
    }

    private static void phantomReferenceExample() {
        LinkedList<PhantomReference<VeryBig>> softReferences = new LinkedList<>();
        IntStream.range(0, 10).forEach(i -> {
            softReferences.add(new PhantomReference<>(new VeryBig("Phantom " + i), referenceQueue));
            System.out.println("Just created: " + softReferences.getLast().get());
            checkQueue();
        });
    }

    private static void checkQueue() {
        Reference<? extends VeryBig> reference = referenceQueue.poll();
        if (reference != null) {
            System.out.println("In reference queue: " + reference.get());
        }
    }

    private static class VeryBig {
        private static final int SIZE = 10000;
        private long[] la = new long[SIZE];
        private String indentifier;

        private VeryBig(String indentifier) {
            this.indentifier = indentifier;
        }

        @Override
        public String toString() {
            return "VeryBig{" +
                    indentifier + '\'' +
                    '}';
        }

        protected void finalize() {
            System.out.println("Finilizing " + indentifier);
        }
    }
}
