package ru.akhitev.kb.java8.enum_examples;

public class BasicEnumMethods {
    public static void main(String[] args) {
        for (Ships ship : Ships.values()) {
            System.out.print(ship.name() + " ");
            System.out.print(ship.ordinal() + " ");
            System.out.print(ship.getDeclaringClass() + " ");
            System.out.print(ship.equals(Ships.CRUISER) + " ");
            System.out.println(ship == Ships.CRUISER);
        }
        System.out.println("====");
        System.out.println(Ships.valueOf("DREADNOUGHT"));
        System.out.println(Enum.valueOf(Ships.class,"CARRIER") + "\n=====");
        Ships ship = Ships.DREADNOUGHT;
        switch (ship) {
            case CARRIER:
                System.out.println("carrier");
                break;
            case DREADNOUGHT:
                System.out.println("dreadnought");
                break;
            default:
                System.out.println("other type");
        }
    }

    enum Ships {
        CORVETTE, CRUISER, FRIGATE, DREADNOUGHT, CARRIER;
    }
}
