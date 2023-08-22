package ru.akhitev.kb.spring.envers.repo;

import org.springframework.data.repository.CrudRepository;
import ru.akhitev.kb.spring.envers.entity.FleetUnit;

public interface FleetUnitRepo extends CrudRepository<FleetUnit, Long> {
}
