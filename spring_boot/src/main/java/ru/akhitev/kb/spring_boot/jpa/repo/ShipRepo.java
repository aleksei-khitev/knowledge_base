package ru.akhitev.kb.spring_boot.jpa.repo;

import org.springframework.data.repository.CrudRepository;
import ru.akhitev.kb.spring_boot.jpa.entity.Ship;

public interface ShipRepo extends CrudRepository<Ship, Long> {
}
