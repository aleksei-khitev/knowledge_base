package ru.akhitev.kb.java8.enum_examples;

public class EnumOfEnums {
    public static void main(String[] args) {
        Ship someShip = Ship.MilitaryShip.CRUISER;
        someShip = Ship.CivilShip.TRANSPORTER;
    }

    private interface Ship {
        enum CivilShip implements Ship {
            LINER, FERRY, TRANSPORTER;
        }

        enum MilitaryShip implements Ship {
            CORVETTE, CRUISER, FRIGATE, DREADNOUGHT, CARRIER;
        }
    }
}
