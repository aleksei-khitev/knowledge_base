package ru.akhitev.kb.spring.jdbc_spring.data_source_dao;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.akhitev.kb.spring.jdbc_spring.plain_dao.dao.FleetUnitDao;
import ru.akhitev.kb.spring.jdbc_spring.plain_dao.entity.FleetUnit;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataSourceTest {
    private static Logger logger = LoggerFactory.getLogger(DataSourceTest.class);

    @Test
    public void testWithJavaConfig() throws SQLException {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(DbConfig.class);
        DataSource dataSource = context.getBean(DataSource.class);
        Assert.assertNotNull(dataSource);
        FleetUnitDao fleetUnitDao = context.getBean(FleetUnitDao.class);
        listFleetUnits(fleetUnitDao);

        FleetUnit fleetUnit = new FleetUnit();
        fleetUnit.setName("Squat Line");
        insertFleetUnit(fleetUnitDao, fleetUnit);
        listFleetUnits(fleetUnitDao);

        deleteFleetUnit(fleetUnitDao, fleetUnit);
        listFleetUnits(fleetUnitDao);
    }

    private static void listFleetUnits(FleetUnitDao fleetUnitDao) {
        logger.info("List Fleet Units");
        List<FleetUnit> fleetUnits = fleetUnitDao.findAll();
        logger.info("Fleet Units found in DB: {}", fleetUnits);
        logger.info("================");
    }

    private static void insertFleetUnit(FleetUnitDao fleetUnitDao, FleetUnit fleetUnit) {
        logger.info("Insert Fleet Unit");
        logger.info("Fleet unit to be inserted: {}", fleetUnit);
        fleetUnitDao.insert(fleetUnit);
        logger.info("Fleet unit after insertion: {}", fleetUnit);
        logger.info("================");
    }

    private static void deleteFleetUnit(FleetUnitDao fleetUnitDao, FleetUnit fleetUnit) {
        logger.info("Delete Fleet Unit");
        logger.info("Fleet unit to be deleted: {}", fleetUnit);
        fleetUnitDao.delete(fleetUnit.getId());
        logger.info("================");
    }
}
