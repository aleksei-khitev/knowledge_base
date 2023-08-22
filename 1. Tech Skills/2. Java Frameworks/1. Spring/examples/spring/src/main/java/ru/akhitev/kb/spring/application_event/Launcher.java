package ru.akhitev.kb.spring.application_event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.akhitev.kb.spring.application_event.battleground.BattleGround;

public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("spring/application_event/beans.xml");
        context.getBean(BattleGround.class).fight();
    }
}
