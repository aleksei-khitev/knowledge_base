package ru.akhitev.kb.spring.hibernate.dao;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.akhitev.kb.spring.hibernate.entity.State;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
public class StateDao {
    private static Logger logger = LoggerFactory.getLogger(StateDao.class);
    private SessionFactory sessionFactory;

    @Autowired
    public StateDao(SessionFactory sessionFactory, DataSource dataSource) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<State> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from State s").list();
    }
}
