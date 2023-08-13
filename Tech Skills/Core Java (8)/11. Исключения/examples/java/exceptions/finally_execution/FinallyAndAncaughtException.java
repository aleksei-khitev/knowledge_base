package exceptions.finally_execution;

public class FinallyAndAncaughtException {
    public static void main(String[] args) {
        try {
            methodWithThrowing();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Finally block is executed and it's executed before throwing away uncaught exception.
     */
    private static void methodWithThrowing() {
        try {
            throw new RuntimeException();
        } finally {
            System.err.println("finally");
        }
    }
}
