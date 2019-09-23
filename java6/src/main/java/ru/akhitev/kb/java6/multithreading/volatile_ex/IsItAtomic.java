package ru.akhitev.kb.java6.multithreading.volatile_ex;

public class IsItAtomic {
    public static void main(String[] args) {
        int i = 0;
        i++;
        System.out.println(i);
    }
}
