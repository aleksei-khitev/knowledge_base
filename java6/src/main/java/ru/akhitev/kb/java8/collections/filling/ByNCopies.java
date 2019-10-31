package ru.akhitev.kb.java8.collections.filling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ByNCopies {
    public static void main(String[] args) {
        List<SomeSubClass> list = new ArrayList<>(Collections.nCopies(5, new SomeSubClass()));
        System.out.println(list);
    }

    private static class SomeSubClass {}
}
