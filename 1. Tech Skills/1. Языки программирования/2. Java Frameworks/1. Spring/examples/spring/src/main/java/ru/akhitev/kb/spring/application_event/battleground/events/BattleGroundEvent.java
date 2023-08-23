package ru.akhitev.kb.spring.application_event.battleground.events;

import org.springframework.context.ApplicationEvent;

public class BattleGroundEvent extends ApplicationEvent {
    private final Type type;

    public BattleGroundEvent(Object source, Type type) {
        super(source);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        START, STOP
    }
}
