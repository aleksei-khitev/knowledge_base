package ru.akhitev.kb.spring.value_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("spring/value_annotation/beans.xml");
        MessageBeam messageBeam = context.getBean(MessageBeam.class);
        messageBeam.repeat();
    }
}
