package ru.akhitev.kb.spring.parent_context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.akhitev.kb.spring.parent_context.ships.MilitaryShip;

public class Launcher {
    public static void main(String[] args) {
        ApplicationContext parentContext = new GenericXmlApplicationContext("spring/parent_context/parent.xml");
        GenericXmlApplicationContext childContext = new GenericXmlApplicationContext();
        childContext.load("spring/parent_context/child.xml");
        childContext.setParent(parentContext);
        childContext.refresh();
        MilitaryShip ship = childContext.getBean("ISD", MilitaryShip.class);
        System.out.println(ship);
    }
}
