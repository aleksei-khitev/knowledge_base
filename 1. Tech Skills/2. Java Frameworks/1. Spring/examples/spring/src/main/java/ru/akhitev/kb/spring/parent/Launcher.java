package ru.akhitev.kb.spring.parent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("spring/parent/beans.xml");
        System.out.println(context.getBeansOfType(Character.class));
        context = new GenericXmlApplicationContext("spring/parent/beans_with_abstract_parent.xml");
        System.out.println(context.getBeansOfType(Character.class));
    }
}
