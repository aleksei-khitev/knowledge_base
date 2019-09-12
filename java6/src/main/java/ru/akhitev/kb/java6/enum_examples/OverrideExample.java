package ru.akhitev.kb.java6.enum_examples;

public class OverrideExample {
    public static void main(String[] args) {
        for (StarFighter starFighter : StarFighter.values()) {
            System.out.println(starFighter + " battlefield: " + starFighter.battlefield());
        }
    }

    private enum StarFighter {
        ZEFFIR, STAR_FURY, THUNDERBOLT {
            @Override
            String battlefield() {
                return "Space and Atmosphere";
            }
        };

        String battlefield() {
            return "Space";
        }
    }
}
