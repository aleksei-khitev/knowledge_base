package ru.akhitev.kb.spring.transaction.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.akhitev.kb.spring.transaction.entity.FleetUnit;
import ru.akhitev.kb.spring.transaction.repo.FleetUnitRepo;

import java.util.Optional;

@Service
public class FleetService {
    private static Logger logger = LoggerFactory.getLogger(FleetService.class);
    private FleetUnitRepo fleetUnitRepo;

    @Autowired
    public FleetService(FleetUnitRepo fleetUnitRepo) {
        this.fleetUnitRepo = fleetUnitRepo;
    }

    public void listAllFleets() {
        fleetUnitRepo.findAll().forEach(unit -> logger.info(unit.toString()));
    }

    public Optional<FleetUnit> fleetUnitById(Long id) {
        return fleetUnitRepo.findById(id);
    }
}
