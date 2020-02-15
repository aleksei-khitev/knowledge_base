package ru.akhitev.kb.spring.environment_properties_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("spring/environment_properties_injection/beans.xml");
        System.out.println(context.getBean(HomeInfrastructureInfo.class));
    }
}
