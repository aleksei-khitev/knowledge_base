package ru.akhitev.kb.java6.exceptions.finally_execution;

public class FinallyAndBreak {
    public static void main(String[] args) {
        finallyExecutesBeforeBreak();
    }

    /**  Even if we break an iteration of a loop, finally block is executes before it. */
    private static void finallyExecutesBeforeBreak() {
        for (int i = 0; i <10; i++) {
            if (i == 5) {
                try {
                    System.out.println("before break");
                    break;
                } finally {
                    System.out.println("finally at break case");
                }
            }
            System.out.println(i);
        }
    }
}
