package ru.akhitev.kb.spring.jdbc_spring.plain_dao.dao;

import ru.akhitev.kb.spring.jdbc_spring.plain_dao.entity.FleetUnit;

import java.util.List;

public interface FleetUnitDao {
    List<FleetUnit> findAll();
    List<FleetUnit> findByName(String name);
    void insert(FleetUnit fleetUnit);
    void update(FleetUnit fleetUnit);
    void delete(Long fleetUnitId);

    List<FleetUnit> findAllWithDetail();
    List<FleetUnit> insertWithDetail(FleetUnit fleetUnit);
}
