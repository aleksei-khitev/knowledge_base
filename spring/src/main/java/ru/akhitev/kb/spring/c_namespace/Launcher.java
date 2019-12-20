package ru.akhitev.kb.spring.c_namespace;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("spring/c_namespace/beans.xml");
        MessageBeam messageBeam = context.getBean(MessageBeam.class);
        messageBeam.repeatMessage();
    }
}
