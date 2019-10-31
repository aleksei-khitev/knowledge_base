package ru.akhitev.kb.java8.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class ConcurrentModificationExceptionAtItaration {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("a");
        collection.add("b");
        collection.add("c");
        Iterator<String> iterator = collection.iterator();
        collection.add("d");
        try {
            iterator.next();
        } catch (ConcurrentModificationException e) {
            System.out.println("As we expected: " + e);
        }
    }
}
