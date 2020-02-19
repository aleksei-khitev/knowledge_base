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
        Assert.assertEquals("Persuade Line", name);
    }

    @Test
    public void when_getNameByIdFunctionInvoken_then_returnName() {
        String name = dao.getNameByIdViaFunction(1L);
        Assert.assertNotNull(name);
        logger.info("name = {}", name);
        Assert.assertEquals("Persuade Line", name);
    }

    @Test
    public void when_findAll_then_return_allFleetUnits() {
        List<FleetUnit> fleetUnits = dao.findAll();
        Assert.assertNotNull(fleetUnits);
        logger.info("fleetUnits = {}", fleetUnits);
    }

    @Test
    public void when_updateByName_then_nameUpdated() {
        logger.info("fleetUnits = {}", dao.findAll());
        dao.updateName(1L, "PL");
        logger.info("fleetUnits = {}", dao.findAll()); // Возвращает из кэша, видимо. В консоле базы видно, что поменялось
        dao.updateName(1L, "Persuade Line");
        logger.info("fleetUnits = {}", dao.findAll());
    }

    @Test
    public void when_insertFleetUnit_then_idGenerated() {
        logger.info("fleetUnits = {}", dao.findAll());
        FleetUnit fleetUnit = new FleetUnit();
        fleetUnit.setName("Scout Line");
        dao.insert(fleetUnit);
        logger.info("fleetUnits = {}", dao.findAll());
        dao.delete(fleetUnit.getId());
        logger.info("fleetUnits = {}", dao.findAll());
    }

    @Test
    public void having_fleetUnitDao_when_findAllWithShips_then_return_allFleetUnitsWithShips() {
        List<FleetUnit> fleetUnits = dao.findAllWithShips();
        Assert.assertNotNull(fleetUnits);
        logger.info("fleetUnits = {}", fleetUnits);
    }
}
