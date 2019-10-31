package ru.akhitev.kb.java8.io.serializable;

import java.io.*;

public class TransientExample {
    public static void main(String[] args) {
        String fileName = "/home/aleksei_khitev/test4.out";
        serialize(fileName);
        deSerialize(fileName);
    }

    private static void serialize(String fileName) {
        SomeClass someClass = new SomeClass();
        someClass.someKey = "link to docs";
        someClass.someValue = "docs.oracle.com/javase/tutoria";
        someClass.confidentInfo = "Очень важный пароль";
        System.out.println("Object for seraliation: " + someClass);
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(someClass);
        } catch (IOException e) { e.printStackTrace(); }
    }

    private static void deSerialize(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Object deSerializedObject = objectInputStream.readObject();
            if (deSerializedObject instanceof SomeClass) {
                SomeClass someClass = (SomeClass) deSerializedObject;
                System.out.println("DeSerialized object: " + someClass);
            }
        } catch (IOException | ClassNotFoundException e) { e.printStackTrace(); }
    }

    public static class SomeClass implements Serializable {
        private String someKey;
        private String someValue;
        private transient String confidentInfo;

        @Override
        public String toString() {
            return "SomeClass{" + someKey + "," + someValue + "," + confidentInfo + '}';
        }
    }
}
