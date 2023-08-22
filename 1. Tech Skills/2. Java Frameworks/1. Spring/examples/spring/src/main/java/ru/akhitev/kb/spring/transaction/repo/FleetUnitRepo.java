package ru.akhitev.kb.spring.transaction.repo;

import org.springframework.data.repository.CrudRepository;
import ru.akhitev.kb.spring.transaction.entity.FleetUnit;

public interface FleetUnitRepo extends CrudRepository<FleetUnit, Long> {
}
