package ru.akhitev.kb.spring.jpa.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.akhitev.kb.spring.jpa.conf.AppConfig;

import javax.persistence.EntityManagerFactory;

public class FleetUnitServiceSpec {

    @Test
    public void test() {
        ApplicationContext context = new GenericXmlApplicationContext("spring/jpa/beans.xml");
        //ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean(EntityManagerFactory.class);
    }
}
