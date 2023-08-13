package ru.akhitev.kb.java8.exceptions.finally_execution;

public class FinallyAndReturn {
    public static void main(String[] args) {
        finallyExecutesBeforeReturn();
        System.out.println("after return in main");
    }

    /**
     * Even if we exit a method by return, finally block is executes before it.
     *
     * @return some integer. Doesn't matter
     */
    private static int finallyExecutesBeforeReturn() {
        try {
            int someOutput = 1;
            System.out.println("before return");
            return someOutput;
        } finally {
            System.out.println("finally");
        }
    }
}
