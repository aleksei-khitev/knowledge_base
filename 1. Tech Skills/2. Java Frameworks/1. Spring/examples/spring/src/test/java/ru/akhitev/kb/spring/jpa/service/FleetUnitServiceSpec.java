package ru.akhitev.kb.spring.jpa.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.akhitev.kb.spring.jpa.conf.AppConfig;
import ru.akhitev.kb.spring.jpa.entity.FleetUnit;

import java.util.List;

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
        List<FleetUnit> all = fleetUnitService.findAllWithNamedQuery();
        logger.info("fleetUnits: {}", all);
        logger.info("auditor info. createdBy: {}, createdDate: {}, lastModifiedBy: {}, lastModifiedDate: {}",
                fleetUnit.getCreatedBy(), fleetUnit.getCreatedDate(),
                fleetUnit.getLastModifiedBy(), fleetUnit.getLastModifiedDate());
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

    @Test
    public void findByFewNames() {
        ApplicationContext context = new GenericXmlApplicationContext("spring/jpa/beans.xml");
        FleetUnitService fleetUnitService = context.getBean(FleetUnitService.class);
        logger.info("По критераю: {}", fleetUnitService.findByFewNames("Разведывательная линия", "Разведывательно-ударная линия"));
    }

    @Test
    public void findAllWithRepo() {
        ApplicationContext context = new GenericXmlApplicationContext("spring/jpa/beans.xml");
        FleetUnitService fleetUnitService = context.getBean(FleetUnitService.class);
        logger.info("fleetUnits: {}", fleetUnitService.findAllWithRepo());
    }

    @Test
    public void findByNameWithRepo() {
        ApplicationContext context = new GenericXmlApplicationContext("spring/jpa/beans.xml");
        FleetUnitService fleetUnitService = context.getBean(FleetUnitService.class);
        logger.info("fleetUnits: {}", fleetUnitService.findByNameWithRepo("Разведывательная линия"));
    }

    @Test
    public void findByNameAndCommandRankNameWithSpecialQueryInRepo() {
        ApplicationContext context = new GenericXmlApplicationContext("spring/jpa/beans.xml");
        FleetUnitService fleetUnitService = context.getBean(FleetUnitService.class);
        logger.info("fleetUnits: {}", fleetUnitService
                .findByNameAndCommandRankNameWithSpecialQueryInRepo("Разведывательная линия", "Линейный капитан"));
    }
}
