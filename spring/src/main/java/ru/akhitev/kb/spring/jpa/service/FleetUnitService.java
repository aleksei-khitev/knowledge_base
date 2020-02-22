package ru.akhitev.kb.spring.jpa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.akhitev.kb.spring.jpa.entity.FleetUnit;
import ru.akhitev.kb.spring.jpa.entity.FleetUnitAndCommandRank;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.Iterator;
import java.util.List;

import static ru.akhitev.kb.spring.jpa.entity.FleetUnit.FLEET_UNIT_NAME_AND_COMMAND_RANK_NAME;

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
        List<?> result = entityManager
                .createQuery("select fu.name, fu.commandRank.name from FleetUnit fu ")
                .getResultList();
        for (Iterator<?> i = result.iterator(); i.hasNext(); ) {
            Object[] values = (Object[]) i.next();
            logger.info(values[0] + ": " + values[1]);
        }
    }

    @Transactional(readOnly = true)
    public void displayFleetUnitAndCommandRankViaConstructor() {
        logger.info("List<FleetUnitAndCommandRank>:  {}", entityManager
                .createQuery("select " +
                        "new ru.akhitev.kb.spring.jpa.entity.FleetUnitAndCommandRank(fu.name, fu.commandRank.name) " +
                        "from FleetUnit fu", FleetUnitAndCommandRank.class)
                .getResultList());
    }

    @Transactional(readOnly = true)
    public void displayFleetUnitAndCommandRankViaResultSetMapping() {
        List<FleetUnitAndCommandRank> result = entityManager
                .createNativeQuery("select fu.name, cr.name from fleet_unit fu" +
                        "join command_rank cr on cr.id = uf.minimum_command_rank_id", FLEET_UNIT_NAME_AND_COMMAND_RANK_NAME)
                .getResultList();
        logger.info("result: {}", result);
    }

    public FleetUnit save(FleetUnit fleetUnit) {
        if (fleetUnit.getId() == null) {
            entityManager.persist(fleetUnit);
        } else {
            entityManager.merge(fleetUnit);
        }
        return fleetUnit;
    }

    public void delete(FleetUnit fleetUnit) {
        FleetUnit mergedFleetUnit = entityManager.merge(fleetUnit);
        entityManager.remove(mergedFleetUnit);
    }

    @Transactional(readOnly = true)
    public List<FleetUnit> findByFewNames(String... names) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<FleetUnit> criteriaQuery = criteriaBuilder.createQuery(FleetUnit.class);
        Root<FleetUnit> fleetUnitRoot = criteriaQuery.from(FleetUnit.class);
        CriteriaBuilder.In<String> inClause = criteriaBuilder.in(fleetUnitRoot.get("name"));
        for (String name : names) {
            inClause.value(name);
        }
        CriteriaQuery<FleetUnit> query = criteriaQuery.select(fleetUnitRoot).where(inClause);
        return entityManager.createQuery(query).getResultList();
    }
}
