package ru.akhitev.kb.spring.jpa.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.akhitev.kb.spring.jpa.entity.FleetUnit;

public class FleetUnitServiceSpec {
    Logger logger = LoggerFactory.getLogger(FleetUnitServiceSpec.class);

    @Test
    public void findAllWithNativeQuery() {
        ApplicationContext context = new GenericXmlApplicationContext("spring/jpa/beans.xml");
        FleetUnitService fleetUnitService = context.getBean(FleetUnitService.class);
        logger.info("fleetUnits: {}", fleetUnitService.findAllWithNativeQuery());
    }

    @Test
    public void findAllWithNamedQuery() {
        ApplicationContext context = new GenericXmlApplicationContext("spring/jpa/beans.xml");
        FleetUnitService fleetUnitService = context.getBean(FleetUnitService.class);
        logger.info("fleetUnits: {}", fleetUnitService.findAllWithNamedQuery());
    }

    @Test
    public void findById() {
        ApplicationContext context = new GenericXmlApplicationContext("spring/jpa/beans.xml");
        FleetUnitService fleetUnitService = context.getBean(FleetUnitService.class);
        logger.info("fleetUnit: {}", fleetUnitService.findById(2L));
    }

    @Test
    public void displayFleetUnitAndCommandRank() {
        ApplicationContext context = new GenericXmlApplicationContext("spring/jpa/beans.xml");
        FleetUnitService fleetUnitService = context.getBean(FleetUnitService.class);
        fleetUnitService.displayFleetUnitAndCommandRank();
    }

    @Test
    public void displayFleetUnitAndCommandRankViaConstructor() {
        ApplicationContext context = new GenericXmlApplicationContext("spring/jpa/beans.xml");
        FleetUnitService fleetUnitService = context.getBean(FleetUnitService.class);
        fleetUnitService.displayFleetUnitAndCommandRankViaConstructor();
    }

    @Test
    public void displayFleetUnitAndCommandRankViaResultSetMapping() {
        ApplicationContext context = new GenericXmlApplicationContext("spring/jpa/beans.xml");
        FleetUnitService fleetUnitService = context.getBean(FleetUnitService.class);
        fleetUnitService.displayFleetUnitAndCommandRankViaResultSetMapping();
    }

    @Test
    public void saveNewFleetUnit() {
        ApplicationContext context = new GenericXmlApplicationContext("spring/jpa/beans.xml");
        FleetUnitService fleetUnitService = context.getBean(FleetUnitService.class);
        FleetUnit fleetUnit = new FleetUnit();
        fleetUnit.setName("Линия обеспечения");
        fleetUnitService.save(fleetUnit);
        logger.info("fleetUnits: {}", fleetUnitService.findAllWithNamedQuery());
    }

    @Test
    public void delete() {
        ApplicationContext context = new GenericXmlApplicationContext("spring/jpa/beans.xml");
        FleetUnitService fleetUnitService = context.getBean(FleetUnitService.class);
        logger.info("fleetUnits before: {}", fleetUnitService.findAllWithNamedQuery());
        FleetUnit fleetUnit = fleetUnitService.findById(2L);
        fleetUnitService.delete(fleetUnit);
        logger.info("fleetUnits after: {}", fleetUnitService.findAllWithNamedQuery());
    }
}
