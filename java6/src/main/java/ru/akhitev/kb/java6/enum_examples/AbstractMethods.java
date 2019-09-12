package ru.akhitev.kb.java6.enum_examples;

public class AbstractMethods {
    public static void main(String[] args) {
        for (BasicInfo basicInfo : BasicInfo.values()) {
            System.out.println(basicInfo.getInfo());
        }
    }

    private enum BasicInfo {
        JAVA_HOME {
            String getInfo() {
                return System.getenv("JAVA_HOME");
            }
        }, JAVA_VERSION {
            String getInfo() {
                return System.getProperty("java.version");
            }
        };

        abstract String getInfo();
    }
}
