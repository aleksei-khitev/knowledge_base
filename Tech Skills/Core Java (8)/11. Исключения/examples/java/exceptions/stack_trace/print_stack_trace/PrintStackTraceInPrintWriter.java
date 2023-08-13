package exceptions.stack_trace.print_stack_trace;

import java.io.PrintWriter;

public class PrintStackTraceInPrintWriter {

    public static void main(String[] args) {
        PrintWriter printWriter = new PrintWriter(System.out);
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            e.printStackTrace(printWriter);
        }
        printWriter.close(); // Without close() or flush() nothing will be printed.
    }

}
