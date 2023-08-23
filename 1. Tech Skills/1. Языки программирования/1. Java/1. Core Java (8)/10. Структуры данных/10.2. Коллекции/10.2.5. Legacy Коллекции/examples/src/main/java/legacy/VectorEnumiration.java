package legacy;

import java.util.Enumeration;
import java.util.Vector;

public class VectorEnumiration {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.addElement("a");
        vector.add("b");
        vector.setElementAt("aaa", 0);
        Enumeration<String> enumeration = vector.elements();
        while(enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
}
