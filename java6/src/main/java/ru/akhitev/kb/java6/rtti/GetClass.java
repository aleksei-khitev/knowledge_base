package ru.akhitev.kb.java6.rtti;

import java.util.LinkedList;
import java.util.List;

public class GetClass {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        getClass(list);
    }

    /**
     * getClass() returns real class of the object
     * No generic information, because it was errased on compile time
    */
    private static void getClass(List<String> list) {
        Class listClass = list.getClass();
        System.out.println(listClass.getName());
    }
}

// output:
// -------
// /opt/apps/java/jdk1.8.0_181/bin/java...
// java.util.LinkedList
//
// Process finished with exit code 0