package ru.akhitev.kb.java8.collections;

import java.util.*;

public class CollectionFromArray {
    public static void main(String[] args) {
        //tryUseArrays();
        String[] someArray = new String[]{"b", "a", "c"};
        Arrays.sort(someArray);
        System.out.println(Arrays.toString(someArray));
        Arrays.sort(someArray, Collections.reverseOrder());
        System.out.println(Arrays.toString(someArray));

    }


}
