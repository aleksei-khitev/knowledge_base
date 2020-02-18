package ru.akhitev.kb.spring.jdbc_spring.plain_dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.akhitev.kb.spring.jdbc_spring.plain_dao.dao.FleetUnitDao;
import ru.akhitev.kb.spring.jdbc_spring.plain_dao.dao.PlainFleetUnitDao;
import ru.akhitev.kb.spring.jdbc_spring.plain_dao.entity.FleetUnit;

import java.util.List;

/**
 * В базе `fleet` выполнены следующие запросы:
 *
 * insert into fleet_unit(name) values('Persuage Line');
 * insert into fleet_unit(name) values('Strike Line');
 *
 * insert into ship(name, type, ship_class, fleet_unit_id) values('101','Frigate','Nebulon-B', 1);
 * insert into ship(name, type, ship_class, fleet_unit_id) values('125','Light Cruiser','Carrack', 1);
 * insert into ship(name, type, ship_class, fleet_unit_id) values('112','Frigate','Nebulon-B', 1);
 *
 * insert into ship(name, type, ship_class, fleet_unit_id) values('Avanger','Battle Cruiser','Victory II', 2);
 * insert into ship(name, type, ship_class, fleet_unit_id) values('Flammable','Battle Cruiser','Victory II', 2);
 * insert into ship(name, type, ship_class, fleet_unit_id) values('Devastator','Battle Ship','Imperial I', 2);
 */
public class Launcher {
    private static Logger logger = LoggerFactory.getLogger(Launcher.class);
    private static FleetUnitDao fleetUnitDao = new PlainFleetUnitDao();

    public static void main(String[] args) {
        listFleetUnits();

        FleetUnit fleetUnit = new FleetUnit();
        fleetUnit.setName("Squat Line");
        insertFleetUnit(fleetUnit);
        listFleetUnits();

        deleteFleetUnit(fleetUnit);
        listFleetUnits();
    }

    private static void listFleetUnits() {
        logger.info("List Fleet Units");
        List<FleetUnit> fleetUnits = fleetUnitDao.findAll();
        logger.info("Fleet Units found in DB: {}", fleetUnits);
        logger.info("================");
    }

    private static void insertFleetUnit(FleetUnit fleetUnit) {
        logger.info("Insert Fleet Unit");
        logger.info("Fleet unit to be inserted: {}", fleetUnit);
        fleetUnitDao.insert(fleetUnit);
        logger.info("Fleet unit after insertion: {}", fleetUnit);
        logger.info("================");
    }

    private static void deleteFleetUnit(FleetUnit fleetUnit) {
        logger.info("Delete Fleet Unit");
        logger.info("Fleet unit to be deleted: {}", fleetUnit);
        fleetUnitDao.delete(fleetUnit.getId());
        logger.info("================");
    }
}
