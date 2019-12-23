package ru.akhitev.kb.spring.collection_injecion_via_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("spring/collection_injecion_via_annotation/beans.xml");
        FleetUnit unit = context.getBean(FleetUnit.class);
        System.out.println(unit);
    }
}
