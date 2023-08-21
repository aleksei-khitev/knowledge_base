package enums;

import static enums.BasicEnumMethods.Ships.DREADNOUGHT;

public class ValuesAtEnumAndGetEnumConstraints {
    public static void main(String[] args) {
        Enum someShip = DREADNOUGHT;
        // someShip.values() Нет такого метода
        for (Enum someEnum : someShip.getClass().getEnumConstants()) {
            System.out.println(someEnum);
        }
        Class<Integer> intClass = Integer.class;
        for (Object someEnum : intClass.getEnumConstants()) {
            System.out.println(someEnum);
        }
    }


}
