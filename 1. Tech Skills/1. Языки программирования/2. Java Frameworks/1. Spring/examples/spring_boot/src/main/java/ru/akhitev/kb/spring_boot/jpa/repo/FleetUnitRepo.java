package ru.akhitev.kb.spring_boot.jpa.repo;

import org.springframework.data.repository.CrudRepository;
import ru.akhitev.kb.spring_boot.jpa.entity.FleetUnit;

public interface FleetUnitRepo extends CrudRepository<FleetUnit, Long> {
}
