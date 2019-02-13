package ru.akhitev.kb.java6.rtti.take_class.generic;

public class WithGeneric {

    /**
     * It gives additional check on compile time.
     * For instance, you cannot set double.class to Class<integer> object.
     */
    public static void main(String[] args) {
        Class<Integer> intClass = int.class;
        // intClass = double.class;
    }
}

// compile error if  11 line is uncommented:
// -------
// Incompatible types.
// Required:
// Class
//     <java.lang.Integer>
// Found:
// Class
//     <java.lang.Double>
