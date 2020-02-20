package ru.akhitev.kb.spring.hibernate.dao;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.akhitev.kb.spring.hibernate.entity.FleetUnit;

import java.util.List;

public class FleetUnitSpec {
    private static Logger logger = LoggerFactory.getLogger(FleetUnitSpec.class);
    private FleetUnitDao dao;

    @Before
    public void setUp() {
        ApplicationContext context = new GenericXmlApplicationContext("spring/hibernate/beans.xml");
        dao = context.getBean(FleetUnitDao.class);
    }

    @Test
    public void when_findAll_then_findAll() {
        List<FleetUnit> fleetUnitsSimple = dao.findAll(); // тут не инициализированы ship
        List<FleetUnit> fleetUnits = dao.findAllWithShips(); // а тут инициализированы
        logger.info("All states: {}", fleetUnits);
    }
}
