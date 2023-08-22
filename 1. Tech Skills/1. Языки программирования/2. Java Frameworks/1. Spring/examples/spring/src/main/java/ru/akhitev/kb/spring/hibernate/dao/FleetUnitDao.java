package ru.akhitev.kb.spring.hibernate.dao;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.akhitev.kb.spring.hibernate.entity.FleetUnit;

import java.util.List;

@Transactional
@Repository
public class FleetUnitDao {
    private static Logger logger = LoggerFactory.getLogger(FleetUnitDao.class);
    private SessionFactory sessionFactory;

    @Autowired
    public FleetUnitDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<FleetUnit> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from FleetUnit fu").list();
    }

    public List<FleetUnit> findAllWithShips() {
        return sessionFactory.getCurrentSession()
                .getNamedQuery("FleetUnit.findAllWithShips").list();
    }

    public FleetUnit findAllWithShipsById(Long id) {
        return (FleetUnit) sessionFactory.getCurrentSession()
                .getNamedQuery("FleetUnit.findAllWithShipsById")
                .setParameter("id", id)
                .uniqueResult();
    }

    public FleetUnit save(FleetUnit fleetUnit) {
        sessionFactory.getCurrentSession()
                .saveOrUpdate(fleetUnit);
        return fleetUnit;
    }
}
