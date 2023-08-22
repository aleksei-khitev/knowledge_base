package ru.akhitev.kb.spring.propert_editor;

import java.util.List;

public class Character {
    private String name;
    private List<CraftSummary> craft;

    public Character(String name, List<CraftSummary> craft) {
        this.craft = craft;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + '\'' +
                ", craft=" + craft;
    }
}
