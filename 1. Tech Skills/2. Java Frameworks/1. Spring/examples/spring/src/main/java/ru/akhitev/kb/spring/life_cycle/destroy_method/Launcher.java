package ru.akhitev.kb.spring.life_cycle.destroy_method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        //justApplicationContext();
        //justGenericXmlApplicationContext();
        //genericXmlApplicationContextWithDestroySingletons();
        abstractApplicationContextWithClose();
    }

    private static void genericXmlApplicationContextWithDestroySingletons() {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("spring/life_cycle/destroy_method/beans.xml");
        context.getBean(Retro.class);
        context.getDefaultListableBeanFactory().destroySingletons();
    }

    private static void abstractApplicationContextWithClose() {
        AbstractApplicationContext context = new GenericXmlApplicationContext("spring/life_cycle/destroy_method/beans.xml");
        context.getBean(Retro.class);
        context.close();
    }

    private static void justApplicationContext() {
        ApplicationContext context = new GenericXmlApplicationContext("spring/life_cycle/destroy_method/beans.xml");
        context.getBean(Retro.class);
    }

    private static void justGenericXmlApplicationContext() {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("spring/life_cycle/destroy_method/beans.xml");
        context.getBean(Retro.class);
    }
}
