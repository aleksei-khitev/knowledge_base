package ru.akhitev.kb.spring.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.akhitev.kb.spring.qualifier.ship.OmegaDestroyer;

@Component
public class PatrolMission {
    @Autowired
    @Qualifier("agrippa")
    private OmegaDestroyer destroyer;

    @Override
    public String toString() {
        return "PatrolMission{" +
                "destroyer=" + destroyer.getClass().getSimpleName() +
                '}';
    }
}
