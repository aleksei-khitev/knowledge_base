package ru.akhitev.kb.spring.jpa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.akhitev.kb.spring.jpa.entity.Ship;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Repository
@Transactional
public class ShipService {
    Logger logger = LoggerFactory.getLogger(ShipService.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public Ship getById(Long id) {
        return (Ship) entityManager
                .createNativeQuery("select * from ship where id = :id", Ship.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public void delete(Ship ship) {
        Ship mergedShip = entityManager.merge(ship);
        entityManager.remove(mergedShip);
    }
}
