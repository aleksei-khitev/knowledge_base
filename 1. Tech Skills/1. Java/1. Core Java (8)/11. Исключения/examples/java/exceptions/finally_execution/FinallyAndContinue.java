package exceptions.finally_execution;

public class FinallyAndContinue {
    public static void main(String[] args) {
        finallyExecutesBeforeBreak();
    }

    /** Even if we continue an iteration of a loop, finally block is executes before it. */
    private static void finallyExecutesBeforeBreak() {
        for (int i = 0; i <10; i++) {
            if (i == 5) {
                try {
                    System.out.println("before continue");
                    continue;
                } finally {
                    System.out.println("finally at continue case");
                }
            }
            System.out.println(i);
        }
    }
}
