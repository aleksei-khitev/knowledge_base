package ru.akhitev.kb.spring.envers.service;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.akhitev.kb.spring.envers.entity.Ship;
import ru.akhitev.kb.spring.envers.repo.ShipRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Service
@Transactional
public class ShipService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ShipRepo shipRepo;

    @Transactional(readOnly = true)
    public Optional<Ship> getById(Long id) {
        return shipRepo.findById(id);
    }

    @Transactional
    public void save(Ship ship) {
        shipRepo.save(ship);
    }

    @Transactional
    public Ship findShipByRevision(Long id, int revision) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);
        return auditReader.find(Ship.class, id, revision);
    }
}
