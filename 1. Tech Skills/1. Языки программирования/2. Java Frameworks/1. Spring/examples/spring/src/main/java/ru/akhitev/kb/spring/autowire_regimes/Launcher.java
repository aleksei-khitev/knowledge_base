package ru.akhitev.kb.spring.autowire_regimes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("spring/autowire_regimes/beans.xml");
        context.getBean("unitByName");
        System.out.println("-----");
        context.getBean("unitByType");
        System.out.println("-----");
        context.getBean("unitConstructor");
    }
}
