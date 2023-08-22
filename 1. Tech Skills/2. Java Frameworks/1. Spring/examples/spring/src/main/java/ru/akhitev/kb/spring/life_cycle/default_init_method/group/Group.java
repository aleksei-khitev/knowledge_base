package ru.akhitev.kb.spring.life_cycle.default_init_method.group;

import ru.akhitev.kb.spring.life_cycle.default_init_method.players.Player;

import java.util.List;

public class Group {
    List<Player> players;

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void init() {
        System.out.println("-------\nReady Check:\n------");
        players.forEach(System.out::println);
    }
}
