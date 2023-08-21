package legacy;

import java.util.BitSet;

public class BitSetExample {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        bitSet.set(1);
        bitSet.set(2);
        bitSet.set(3);
        System.out.println(bitSet);
        bitSet.clear(2);
        System.out.println(bitSet);
    }
}
