package ru.akhitev.kb.spring.life_cycle.initializing_bean.group;

import org.springframework.beans.factory.InitializingBean;
import ru.akhitev.kb.spring.life_cycle.initializing_bean.players.Player;

import java.util.List;

public class Group implements InitializingBean {
    List<Player> players;

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("-------\nReady Check:\n------");
        players.forEach(System.out::println);
    }
}
