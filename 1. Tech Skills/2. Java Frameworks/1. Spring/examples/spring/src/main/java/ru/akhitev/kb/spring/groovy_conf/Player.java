package ru.akhitev.kb.spring.groovy_conf;

public class Player {
    private String name;
    private int level;

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return name + " (" + level + ')';
    }
}
