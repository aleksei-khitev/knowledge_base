package ru.akhitev.kb.java8.io.serializable;

import java.io.*;

public class SerializeClassWithStaticExample {
    public static void main(String[] args) {
        String fileName = "/home/aleksei_khitev/test4.out";
        //serializeClass(fileName);
        deserializeClass(fileName);
    }

    private static void serializeClass(String fileName) {
        SomeClassWithStatic.someMagicNumber = 2;
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(SomeClassWithStatic.class);
            objectOutputStream.writeInt(SomeClassWithStatic.someMagicNumber);
        } catch (IOException e) { e.printStackTrace(); }
    }

    private static void deserializeClass(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Object deserializedObject = objectInputStream.readObject();
            if (deserializedObject instanceof Class) {
                Class<SomeClassWithStatic> clazz = (Class<SomeClassWithStatic>) deserializedObject;
                int someMagicNumber = objectInputStream.readInt();
                SomeClassWithStatic.setSomeMagicNumber(someMagicNumber);
                System.out.println("someMagicNumber: " + SomeClassWithStatic.getSomeMagicNumber());
            }
        } catch (IOException | ClassNotFoundException e) { e.printStackTrace(); }
    }

    public static class SomeClassWithStatic {
        public static int someMagicNumber;

        public static int getSomeMagicNumber() { return someMagicNumber; }

        private static void setSomeMagicNumber(int value) {
            someMagicNumber = value;
        }
    }
}
