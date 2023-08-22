package ru.akhitev.kb.spring.groovy_conf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context = new GenericGroovyApplicationContext("spring/groovy_conf/beans.groovy");
        System.out.println(context.getBean(Roster.class));
    }
}
