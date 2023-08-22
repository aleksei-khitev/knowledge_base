package ru.akhitev.kb.spring.application_event.players;

import org.springframework.context.ApplicationListener;
import ru.akhitev.kb.spring.application_event.battleground.events.BattleGroundEvent;

public class Player implements ApplicationListener<BattleGroundEvent> {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void onApplicationEvent(BattleGroundEvent event) {
        switch (event.getType()) {
            case START:
                System.out.println(name + " приступил к бою!");
                break;
            case STOP:
                System.out.println(name + " покидает арену.");
                break;
        }
    }
}
