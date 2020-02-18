package ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao.dao.FleetUnitDao;
import ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao.dao.ShipDao;

public class JdbcTemplateDaoTest {
    private static Logger logger = LoggerFactory.getLogger(JdbcTemplateDaoTest.class);
    private AbstractApplicationContext context;
    private FleetUnitDao fleetUnitDao;
    private ShipDao shipDao;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(DbConfig.class);
        fleetUnitDao = context.getBean(FleetUnitDao.class);
        shipDao = context.getBean(ShipDao.class);
    }

    @Test
    public void having_existingFleet_when_findNameById_then_return_Name() {
        String name = fleetUnitDao.findNameById(1L);
        Assert.assertNotNull(name);
        logger.info("name = {}", name);
        Assert.assertEquals("Persuage Line", name);
    }

    @Test
    public void having_existingShip_when_findNameById_then_return_Name() {
        String name = shipDao.findNameById(1L);
        Assert.assertNotNull(name);
        logger.info("name = {}", name);
        Assert.assertEquals("101", name);
    }
}
