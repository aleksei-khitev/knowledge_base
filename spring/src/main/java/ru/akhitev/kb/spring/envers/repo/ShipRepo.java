package ru.akhitev.kb.spring.envers.repo;

import org.springframework.data.repository.CrudRepository;
import ru.akhitev.kb.spring.envers.entity.Ship;

public interface ShipRepo extends CrudRepository<Ship, Long> {
}
