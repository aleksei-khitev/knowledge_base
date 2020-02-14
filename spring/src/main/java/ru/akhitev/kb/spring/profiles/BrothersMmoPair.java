package ru.akhitev.kb.spring.profiles;

import java.util.List;

public class BrothersMmoPair {
    private String game;
    private List<String> names;

    public BrothersMmoPair(String game, List<String> names) {
        this.names = names;
        this.game = game;
    }

    @Override
    public String toString() {
        return "Пара в \'" + game + "\': " + names;
    }
}
