package ru.akhitev.kb.java6.rtti.cast;

public class CastExample {

    public static void main(String[] args) {
        Ship cruiserShip = new Cruiser();
        Class<Cruiser> cruiserClass = Cruiser.class;
        Cruiser castedCruiser = cruiserClass.cast(cruiserShip);
        System.out.println(castedCruiser.getClass());
    }
}

// output:
// -------
// /opt/apps/java/jdk1.8.0_181/bin/java...
// class ru.akhitev.kb.java6.rtti.cast.Cruiser
//
// Process finished with exit code 0