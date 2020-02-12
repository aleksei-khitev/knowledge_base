package ru.akhitev.kb.spring.destroy_mehod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("spring/destroy_mehod/beans.xml");
        context.getBean(Retro.class);
        context.getDefaultListableBeanFactory().destroySingletons();
    }
}
