package ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.DbConfig;
import ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.dao.fleet_unit.FleetUnitDao;
import ru.akhitev.kb.spring.jdbc_spring.plain_dao.entity.FleetUnit;

import java.util.List;

public class FleetUnitDaoSpec {
    private static Logger logger = LoggerFactory.getLogger(FleetUnitDaoSpec.class);
    private FleetUnitDao dao;

    @Before
    public void setUp() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
        dao = context.getBean(FleetUnitDao.class);
    }

    @Test
    public void having_existingFleet_when_findNameById_then_return_Name() {
        String name = dao.findNameById(1L);
        Assert.assertNotNull(name);
        logger.info("name = {}", name);
        Assert.assertEquals("Persuage Line", name);
    }

    @Test
    public void when_findAll_then_return_allFleetUnits() {
        List<FleetUnit> fleetUnits = dao.findAll();
        Assert.assertNotNull(fleetUnits);
        logger.info("fleetUnits = {}", fleetUnits);
    }

    @Test
    public void having_fleetUnitDao_when_findAllWithShips_then_return_allFleetUnitsWithShips() {
        List<FleetUnit> fleetUnits = dao.findAllWithShips();
        Assert.assertNotNull(fleetUnits);
        logger.info("fleetUnits = {}", fleetUnits);
    }
}
