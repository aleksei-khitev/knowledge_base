package ru.akhitev.kb.spring.replace_method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Launcher {

    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("spring/replace_method/beans.xml");
        System.out.println(context.getBean("replacementTarget", JediTempleMessageBeacon.class).getMessage());
        System.out.println(context.getBean("withoutReplacement", JediTempleMessageBeacon.class).getMessage());
    }
}
