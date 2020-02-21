package ru.akhitev.kb.spring.jpa.service;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.akhitev.kb.spring.jpa.entity.Ship;
import ru.akhitev.kb.spring.jpa.conf.AppConfig;

public class ShipServiceSpec {
    private static Logger logger = LoggerFactory.getLogger(ShipServiceSpec.class);
    private ShipService service;

    @Before
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        service = context.getBean(ShipService.class);
    }

    @Test
    public void getAndDeleteShip() {
        Ship ship = service.getById(1L);
        service.delete(ship);
    }
}
