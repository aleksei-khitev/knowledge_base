package thread.uncaught_exception_handler;

public class WithHandler {
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableWithThrowingException());
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }

    private static class ExceptionHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("Теперь точно поймал\n-----");
            e.printStackTrace();
        }
    }
}
