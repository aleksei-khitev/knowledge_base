package ru.akhitev.kb.spring.propert_editor;

public class CraftSummary {
    private String name;
    private int level;
    private int masteryLevel;
    private boolean isGuild;

    public CraftSummary(String name, int level, int masteryLevel, boolean isGuild) {
        this.name = name;
        this.level = level;
        this.masteryLevel = masteryLevel;
        this.isGuild = isGuild;
    }

    @Override
    public String toString() {
        return "{" + name + '\'' +
                ", уровень: " + level +
                ", крит: " + masteryLevel +
                (isGuild ? ", гильдия":"") +
                '}';
    }
}
