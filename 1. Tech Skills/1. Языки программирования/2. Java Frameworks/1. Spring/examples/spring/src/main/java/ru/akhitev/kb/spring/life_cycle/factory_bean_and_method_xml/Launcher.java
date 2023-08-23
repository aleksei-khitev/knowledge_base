package ru.akhitev.kb.spring.life_cycle.factory_bean_and_method_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("spring/life_cycle/factory_bean_and_method_xml/beans.xml");
        System.out.println(context.getBean(Operation.class).getAgent().theOnlyReply());
    }
}
