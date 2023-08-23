package ru.akhitev.kb.spring.propert_editor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("spring/propert_editor/beans.xml");
        System.out.println(context.getBean(Character.class));
    }
}
