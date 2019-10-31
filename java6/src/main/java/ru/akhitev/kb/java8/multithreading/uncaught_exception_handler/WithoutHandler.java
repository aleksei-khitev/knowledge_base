package ru.akhitev.kb.java8.multithreading.uncaught_exception_handler;

public class WithoutHandler {
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableWithThrowingException());
        try {
            thread.start();
        } catch (Exception e) {
            System.out.println("Я поймал!)");
        }
    }
}
