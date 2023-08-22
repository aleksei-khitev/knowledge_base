package ru.akhitev.kb.spring.primary_annotation;

import org.springframework.stereotype.Component;
import ru.akhitev.kb.spring.primary_annotation.ship.OmegaDestroyer;

@Component
public class PatrolMission {
    private OmegaDestroyer destroyer;

    public PatrolMission(OmegaDestroyer destroyer) {
        this.destroyer = destroyer;
    }

    @Override
    public String toString() {
        return "PatrolMission{" +
                "destroyer=" + destroyer.getClass().getSimpleName() +
                '}';
    }
}
