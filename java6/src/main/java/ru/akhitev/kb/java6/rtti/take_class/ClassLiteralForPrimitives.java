package ru.akhitev.kb.java6.rtti.take_class;

public class ClassLiteralForPrimitives {

    public static void main(String[] args) {
        voidClass();
        booleanClass();
        charClass();
        byteClass();
        shortClass();
        intClass();
        longClass();
        floatClass();
        doubleClass();
    }

    private static void voidClass() {
        Class<Void> booleanClassViaPrimitiveClass = void.class;
        Class<Void> BooleanClassViaType = Void.TYPE;
    }

    private static void booleanClass() {
        Class<Boolean> booleanClassViaPrimitiveClass = boolean.class;
        System.out.println("boolean.class isPrimitive = " + booleanClassViaPrimitiveClass.isPrimitive());
        Class<Boolean> booleanClassViaType = Boolean.TYPE;
        System.out.println("Boolean.TYPE isPrimitive = " + booleanClassViaType.isPrimitive());
    }

    private static void charClass() {
        Class<Character> booleanClassViaPrimitiveClass = char.class;
        Class<Character> BooleanClassViaType = Character.TYPE;
    }

    private static void byteClass() {
        Class<Byte> booleanClassViaPrimitiveClass = byte.class;
        Class<Byte> BooleanClassViaType = Byte.TYPE;
    }

    private static void shortClass() {
        Class<Short> booleanClassViaPrimitiveClass = short.class;
        Class<Short> BooleanClassViaType = Short.TYPE;
    }

    private static void intClass() {
        Class<Integer> booleanClassViaPrimitiveClass = int.class;
        Class<Integer> BooleanClassViaType = Integer.TYPE;
    }

    private static void longClass() {
        Class<Long> booleanClassViaPrimitiveClass = long.class;
        Class<Long> BooleanClassViaType = Long.TYPE;
    }

    private static void floatClass() {
        Class<Float> booleanClassViaPrimitiveClass = float.class;
        Class<Float> BooleanClassViaType = Float.TYPE;
    }

    private static void doubleClass() {
        Class<Double> booleanClassViaPrimitiveClass = double.class;
        Class<Double> BooleanClassViaType = Double.TYPE;
    }
}

// output:
// -------
// /opt/apps/java/jdk1.8.0_181/bin/java...
// boolean.class isPrimitive = true
// Boolean.TYPE isPrimitive = true
//
// Process finished with exit code 0