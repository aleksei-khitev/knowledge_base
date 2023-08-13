package exceptions.finally_lost_exception;

public class LostByReturn {
    public static void main(String[] args) {
        try {
            lostByReturnInFinally();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Even if an exception is thrown in try block,
     * return from finally overrides it.
     */
    private static void lostByReturnInFinally() {
        try {
            throw new RuntimeException();
        } finally {
            return;
        }
    }
}
