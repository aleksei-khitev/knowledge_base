package ru.akhitev.kb.java8.rtti.cast;

public class CastExample {

    public static void main(String[] args) {
        Ship cruiserShip = new Cruiser();
        Class<Cruiser> cruiserClass = Cruiser.class;
        Cruiser castedCruiser = cruiserClass.cast(cruiserShip);
        System.out.println(castedCruiser.getClass());
    }
}
