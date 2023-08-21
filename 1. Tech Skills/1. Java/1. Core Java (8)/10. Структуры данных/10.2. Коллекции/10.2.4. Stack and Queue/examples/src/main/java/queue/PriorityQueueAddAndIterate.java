package queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueAddAndIterate {
    public static void main(String[] args) {
        PriorityQueue<SomeClass> queue = new PriorityQueue<>();
        queue.add(new SomeClass("a"));
        queue.add(new SomeClass("b"));
        queue.add(new SomeClass("c"));
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }

    private static class SomeClass implements Comparable {
        private final String name;

        private SomeClass(String name) {
            this.name = name;
        }

        private String getName() {
            return name;
        }

        @Override
        public int compareTo(Object o) {
            Comparator<SomeClass> comparator = Comparator.comparing(SomeClass::getName).reversed();
            return comparator.compare(this, (SomeClass) o);
        }

        @Override
        public String toString() {
            return "SomeClass{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
