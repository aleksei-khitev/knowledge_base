package ru.akhitev.kb.java6.rtti.take_class.generic;

public class WithGenericExtends {

    public static void main(String[] args) {
        withoutExtends();
        withExtends();
    }

    /**
     * Class object for Integer isn't a subclass of the class object for Number,
     * so we cannot set Class<Integer> to Class<Number>.
     * That's why Class<? extends Number> should be used
     */
    private static void withoutExtends() {
        // Class<Number> someNumberClass = int.class;
    }

    /**
     * Preferable.
     */
    private static void withExtends() {
        Class<? extends Number> someNumberClass = int.class;
        someNumberClass = double.class;
        someNumberClass = Number.class;
    }
}

// compile error if  16 line is uncommented:
// -------
// Incompatible types.
// Required:
// Class
//     <java.lang.Number>
// Found:
// Class
//     <java.lang.Integer>