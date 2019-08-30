package ru.akhitev.kb.java6.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiableCollection {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        unmodifiableList.set(2, "d");
        //unmodifiableList.add("d");
    }
}
