package ru.akhitev.kb.java8.collections.map;

import java.util.HashMap;
import java.util.Map;

public class HashCodeProblemInHashMapExample {
    public static void main(String[] args) {
        Map<SomeClass, String> map = new HashMap<>();
        map.put(new SomeClass(1), "a");
        map.put(new SomeClass(2), "b");
        map.put(new SomeClass(3), "c");
        System.out.println(map.containsKey(new SomeClass(1)));
        System.out.println(map.get(new SomeClass(2)));
    }

    private static class SomeClass {
        private final int someCode;

        private SomeClass(int someCode) {
            this.someCode = someCode;
        }
    }
}
