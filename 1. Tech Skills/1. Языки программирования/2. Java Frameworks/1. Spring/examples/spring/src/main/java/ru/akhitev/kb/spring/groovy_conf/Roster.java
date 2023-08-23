package ru.akhitev.kb.spring.groovy_conf;

import java.util.List;

public class Roster {
    private List<Player> players;

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Roster{" +
                "players=" + players +
                '}';
    }
}
