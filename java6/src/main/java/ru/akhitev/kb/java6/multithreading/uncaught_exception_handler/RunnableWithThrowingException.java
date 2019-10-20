package ru.akhitev.kb.java6.multithreading.uncaught_exception_handler;

class RunnableWithThrowingException implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException("Попробуй поймать меня");
    }
}
