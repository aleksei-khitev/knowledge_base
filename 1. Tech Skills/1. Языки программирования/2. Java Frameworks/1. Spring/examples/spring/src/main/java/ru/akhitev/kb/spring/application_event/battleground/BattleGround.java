package ru.akhitev.kb.spring.application_event.battleground;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import ru.akhitev.kb.spring.application_event.battleground.events.BattleGroundEvent;

import java.util.concurrent.TimeUnit;

public class BattleGround implements ApplicationContextAware {
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void fight() {
        System.out.println("Да будет бой!");
        context.publishEvent(new BattleGroundEvent(this, BattleGroundEvent.Type.START));
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        context.publishEvent(new BattleGroundEvent(this, BattleGroundEvent.Type.STOP));
        System.out.println("Подведем итог!");
    }
}
