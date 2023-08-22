package ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.dao.fleet_unit.FleetUnitDao;
import ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.dao.ship.ShipDao;
import ru.akhitev.kb.spring.jdbc_spring.plain_dao.entity.FleetUnit;

@Service
public class FleetUnitService {
    private FleetUnitDao fleetUnitDao;
    private ShipDao shipDao;

    @Autowired
    public FleetUnitService(FleetUnitDao fleetUnitDao, ShipDao shipDao) {
        this.fleetUnitDao = fleetUnitDao;
        this.shipDao = shipDao;
    }

    public void insertFleetUnitWithShips(FleetUnit fleetUnit) {
        fleetUnitDao.insert(fleetUnit);
        fleetUnit.getShips().forEach(ship -> {
            ship.setFleetUnitId(fleetUnit.getId());
            shipDao.insertShip(ship);
        });
    }
}
