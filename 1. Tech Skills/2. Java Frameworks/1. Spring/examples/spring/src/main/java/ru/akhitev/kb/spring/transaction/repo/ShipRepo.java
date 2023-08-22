package ru.akhitev.kb.spring.transaction.repo;

import org.springframework.data.repository.CrudRepository;
import ru.akhitev.kb.spring.transaction.entity.Ship;

public interface ShipRepo extends CrudRepository<Ship, Long> {
}
