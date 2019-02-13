package ru.akhitev.kb.java6.rtti.take_class;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GetClass {
    static final int compileTimeConst = 47; // Константа времени компиляции
    static final int notCompileTimeConst = nextInt(1000); // Константа времени выполнения


    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        getClass(list);
    }

    private static void getClass(List<String> list) {
        Class listClass = list.getClass();
        System.out.println(listClass.getName());
    }

    private static int nextInt(int i) {
        Random random = new Random();
        return random.nextInt(i);
    }
}

// output:
// -------
// /opt/apps/java/jdk1.8.0_181/bin/java...
// java.util.LinkedList
//
// Process finished with exit code 0