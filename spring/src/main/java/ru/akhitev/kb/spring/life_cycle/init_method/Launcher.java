package ru.akhitev.kb.spring.life_cycle.init_method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.akhitev.kb.spring.life_cycle.init_method.group.Group;

public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("spring/life_cycle/init_method/beans.xml");
        context.getBean(Group.class);
    }
}
