package ru.akhitev.kb.spring.pre_destroy;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        AbstractApplicationContext context = new GenericXmlApplicationContext("spring/pre_destroy/beans.xml");
        context.getBean(Retro.class);
        context.close();
    }
}
