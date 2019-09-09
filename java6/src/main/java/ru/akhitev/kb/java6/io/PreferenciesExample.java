package ru.akhitev.kb.java6.io;

import java.util.prefs.Preferences;

public class PreferenciesExample {
    public static void main(String[] args) {
        //writePref();
        readPref();
    }

    private static void writePref() {
        Preferences preferences = Preferences.userNodeForPackage(PreferenciesExample.class);
        preferences.put("Place", "Babylon5");
        preferences.putInt("Year", 2258);
    }

    private static void readPref() {
        Preferences preferences = Preferences.userNodeForPackage(PreferenciesExample.class);
        System.out.println(preferences.get("Place", "Some Default"));
        System.out.println(preferences.getInt("Year", 2019));
    }
}
