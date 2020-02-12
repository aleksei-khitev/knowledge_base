package ru.akhitev.kb.spring.default_init_method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.akhitev.kb.spring.default_init_method.group.Group;

public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("spring/default_init_method/beans.xml");
        context.getBean(Group.class);
        System.out.println("=====");
        context = new GenericXmlApplicationContext("spring/default_init_method/beans_with_default_init_method.xml");
        context.getBean(Group.class);
    }
}
