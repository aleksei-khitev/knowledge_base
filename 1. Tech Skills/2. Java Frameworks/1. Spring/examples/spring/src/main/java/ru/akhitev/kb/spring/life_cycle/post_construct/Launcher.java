package ru.akhitev.kb.spring.life_cycle.post_construct;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.akhitev.kb.spring.life_cycle.post_construct.group.Group;

public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("spring/life_cycle/post_construct/beans.xml");
        context.getBean(Group.class);
    }
}
