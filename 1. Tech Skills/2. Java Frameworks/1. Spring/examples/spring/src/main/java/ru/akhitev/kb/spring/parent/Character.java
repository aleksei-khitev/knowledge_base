package ru.akhitev.kb.spring.parent;

public class Character {
    private String name;
    private String guild;
    private boolean mainCharacter;

    public void setName(String name) {
        this.name = name;
    }

    public void setGuild(String guild) {
        this.guild = guild;
    }

    public void setMainCharacter(boolean mainCharacter) {
        this.mainCharacter = mainCharacter;
    }

    @Override
    public String toString() {
        return "Игрок {" +
                "имя: '" + name + '\'' +
                ", гильдия: '" + guild + '\'' +
                ", основной персонаж: " + mainCharacter +
                '}';
    }
}
