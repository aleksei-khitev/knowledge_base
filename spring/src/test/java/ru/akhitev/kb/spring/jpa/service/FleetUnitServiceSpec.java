package ru.akhitev.kb.spring.jpa.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

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
}
