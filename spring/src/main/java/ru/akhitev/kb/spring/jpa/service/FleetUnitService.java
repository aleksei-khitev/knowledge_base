package ru.akhitev.kb.spring.jpa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.akhitev.kb.spring.jpa.entity.FleetUnit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Iterator;
import java.util.List;

@Service
@Repository
@Transactional
public class FleetUnitService {
    private static Logger logger = LoggerFactory.getLogger(FleetUnitService.class);
    private final String ALL_FLEET_UNIT_NATIVE_QUERY = "select * from fleet_unit";

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<FleetUnit> findAllWithNativeQuery() {
        return entityManager
                .createNativeQuery(ALL_FLEET_UNIT_NATIVE_QUERY, FleetUnit.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public List<FleetUnit> findAllWithNamedQuery() {
        return entityManager
                .createNamedQuery(FleetUnit.FIND_ALL, FleetUnit.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public FleetUnit findById(Long id) {
        TypedQuery<FleetUnit> query = entityManager
                .createNamedQuery(FleetUnit.FIND_BY_ID, FleetUnit.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Transactional(readOnly = true)
    public void displayFleetUnitAndCommandRank() {
        List result = entityManager
                .createQuery("select fu.name, fu.commandRank.name from FleetUnit fu ")
                .getResultList();
        for (Iterator i = result.iterator(); i.hasNext(); ) {
            Object[] values = (Object[]) i.next();
            logger.info(values[0] + ": " + values[1]);
        }
    }
}
