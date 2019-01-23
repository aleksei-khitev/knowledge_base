package ru.akhitev.kb.java6.exceptions;

public class GetClassGetNameGetSimpleName {
    public static void main(String... args) {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println("getClass: " + e.getClass());
            System.out.println("getName: " + e.getClass().getName());
            System.out.println("getSimpleName: " + e.getClass().getSimpleName());
        }
    }
}

// An output:
// ==========
///opt/apps/java/jdk1.8.0_181/bin/java -javaagent:/opt/apps/idea-IU-182.4892.20/lib/idea_rt.jar=35401:/opt/apps/idea-IU-182.4892.20/bin -Dfile.encoding=UTF-8 -classpath /opt/apps/java/jdk1.8.0_181/jre/lib/charsets.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/deploy.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/ext/cldrdata.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/ext/dnsns.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/ext/jaccess.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/ext/jfxrt.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/ext/localedata.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/ext/nashorn.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/ext/sunec.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/ext/sunjce_provider.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/ext/sunpkcs11.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/ext/zipfs.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/javaws.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/jce.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/jfr.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/jfxswt.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/jsse.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/management-agent.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/plugin.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/resources.jar:/opt/apps/java/jdk1.8.0_181/jre/lib/rt.jar:/development/study/knowledge_base/java6/out/production/classes ru.akhitev.kb.java6.exceptions.GetClassGetNameGetSimpleName
//        getClass: class java.lang.RuntimeException
//        getName: java.lang.RuntimeException
//        getSimpleName: RuntimeException
//
//        Process finished with exit code 0