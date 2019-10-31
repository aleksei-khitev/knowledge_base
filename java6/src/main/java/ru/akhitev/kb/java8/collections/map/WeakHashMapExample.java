package ru.akhitev.kb.java8.collections.map;

import java.util.Objects;
import java.util.WeakHashMap;
import java.util.stream.IntStream;

public class WeakHashMapExample {
    public static void main(String[] args) {
        int size = 1000000;
        Key[] keys = new Key[size];
        WeakHashMap<Key, Value> weakHashMap = new WeakHashMap<>();
        IntStream.range(0, size).forEach(i -> {
            Key key = new Key(Integer.toString(i));
            Value value = new Value(Integer.toString(i));
            if (i % 3 == 0) {
                keys[i] = key; // Сохраняем как "настоящие" ссылки
            }
            weakHashMap.put(key, value);
        });
        System.gc();
    }

    private static class Key extends Element {
        private Key(String identifier) { super(identifier); }
    }

    private static class Value extends Element {
        private Value(String identifier) { super(identifier); }
    }

    private static class Element {
        private String identifier;

        private Element(String identifier) { this.identifier = identifier; }

        @Override
        public String toString() { return "Element{" + identifier + '\'' + '}'; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Element element = (Element) o;
            return Objects.equals(identifier, element.identifier);
        }

        @Override
        public int hashCode() { return Objects.hash(identifier); }

        protected void finalize() { System.out.println("Finalizing " + identifier); }
    }
}
