package io.serializable;

import java.io.*;

public class ExternalizableExample {
    public static void main(String[] args) {
        String fileName = "/home/aleksei_khitev/test2.out";
        serialize(fileName);
        deSerialize(fileName);
    }

    private static void serialize(String fileName) {
        SomeClass someClass = new SomeClass();
        someClass.setSomeKey("link to docs");
        someClass.setSomeValue("docs.oracle.com/javase/tutoria");
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

    public static class SomeClass implements Externalizable {
        private String someKey;
        private String someValue;

        public SomeClass() { System.out.println("Constructor was invoked"); }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            System.out.println("writeExternal wasinvoken: " + out);
            out.writeObject(someKey); // Если этого' не сделать, то будет записан null
            out.writeObject(someValue);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            System.out.println("readExternal wasinvoken: " + in);
            someKey = (String) in.readObject(); // Если этого' не сделать, то объект будет с null в полях
            someValue = (String) in.readObject();
        }

        public String getSomeKey() { return someKey; }
        public void setSomeKey(String someKey) { this.someKey = someKey; }
        public String getSomeValue() { return someValue; }
        public void setSomeValue(String someValue) { this.someValue = someValue; }

        @Override
        public String toString() {
            return "SomeClass{" + someKey + "," + someValue + '}';
        }
    }
}
