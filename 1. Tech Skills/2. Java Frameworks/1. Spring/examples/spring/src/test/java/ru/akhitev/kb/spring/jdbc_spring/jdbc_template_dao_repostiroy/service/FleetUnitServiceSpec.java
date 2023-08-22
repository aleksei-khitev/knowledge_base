package ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.DbConfig;
import ru.akhitev.kb.spring.jdbc_spring.plain_dao.entity.FleetUnit;
import ru.akhitev.kb.spring.jdbc_spring.plain_dao.entity.Ship;

public class FleetUnitServiceSpec {
    private FleetUnitService fleetUnitService;

    @Before
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
        fleetUnitService = context.getBean(FleetUnitService.class);
    }

    @Test
    public void when_fleetUnitWithShipsInsert_then_fleetUnitAndShipsAreInsertedAndIdGenerated() {
        FleetUnit fleetUnit = new FleetUnit();
        fleetUnit.setName("Scout Line");
        Ship ship = new Ship();
        ship.setName("502");
        ship.setType("Corvette");
        ship.setShipClass("Correlian Corvette");
        fleetUnit.addShip(ship);

        ship = new Ship();
        ship.setName("507");
        ship.setType("Corvette");
        ship.setShipClass("Correlian Corvette");
        fleetUnit.addShip(ship);

        ship = new Ship();
        ship.setName("543");
        ship.setType("Corvette");
        ship.setShipClass("Correlian Corvette");
        fleetUnit.addShip(ship);

        ship = new Ship();
        ship.setName("580");
        ship.setType("Corvette");
        ship.setShipClass("Correlian Corvette");
        fleetUnit.addShip(ship);

        ship = new Ship();
        ship.setName("511");
        ship.setType("Corvette");
        ship.setShipClass("Correlian Corvette");
        fleetUnit.addShip(ship);

        fleetUnitService.insertFleetUnitWithShips(fleetUnit);
    }
}
