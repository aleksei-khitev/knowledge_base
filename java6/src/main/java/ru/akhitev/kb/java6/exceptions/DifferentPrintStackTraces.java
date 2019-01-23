package ru.akhitev.kb.java6.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;

public class DifferentPrintStackTraces {
    public static void main(String... args) {
        usualPrintStackTrace();
        printStackTraceAndPrintStream();
        printStackTraceAndPrintWriter();
    }

    private static void usualPrintStackTrace() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    private static void printStackTraceAndPrintStream() {
        PrintStream stream = new PrintStream(System.out);
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            e.printStackTrace(stream);
        }
    }

    private static void printStackTraceAndPrintWriter() {
        PrintWriter printWriter = new PrintWriter(System.out);
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            e.printStackTrace(printWriter);
        }
        printWriter.close(); // Without close() or flush() nothing will be printed.
    }
}

// An output:
// ============
///opt/apps/java/jdk1.8.0_181/bin/java -javaagent:/opt/apps/idea-IU-182.4892.20/lib/idea_rt.jar=35497:/opt/apps/idea-IU-182.4892.20/bin -Dfile.encoding=UTF-8 -classpath /opt/apps/java/jdk1.8.0_181/jre/lib/charsets.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/deploy.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/ext/cldrdata.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/ext/dnsns.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/ext/jaccess.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/ext/jfxrt.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/ext/localedata.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/ext/nashorn.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/ext/sunec.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/ext/sunjce_provider.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/ext/sunpkcs11.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/ext/zipfs.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/javaws.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/jce.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/jfr.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/jfxswt.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/jsse.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/management-agent.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/plugin.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/resources.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/rt.jar:/development/study/knowledge_base/java6/out/production/classes ru.akhitev.kb.java6.exceptions.DifferentPrintStackTraces
//        java.lang.RuntimeException
//        at ru.akhitev.kb.java6.exceptions.DifferentPrintStackTraces.printStackTraceAndPrintStream(DifferentPrintStackTraces.java:24)
//        at ru.akhitev.kb.java6.exceptions.DifferentPrintStackTraces.main(DifferentPrintStackTraces.java:9)
//        java.lang.RuntimeException
//        at ru.akhitev.kb.java6.exceptions.DifferentPrintStackTraces.usualPrintStackTrace(DifferentPrintStackTraces.java:15)
//        at ru.akhitev.kb.java6.exceptions.DifferentPrintStackTraces.main(DifferentPrintStackTraces.java:8)
//        java.lang.RuntimeException
//        at ru.akhitev.kb.java6.exceptions.DifferentPrintStackTraces.printStackTraceAndPrintWriter(DifferentPrintStackTraces.java:33)
//        at ru.akhitev.kb.java6.exceptions.DifferentPrintStackTraces.main(DifferentPrintStackTraces.java:10)
//
//        Process finished with exit code 0