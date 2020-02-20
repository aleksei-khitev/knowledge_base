package ru.akhitev.kb.spring.hibernate.dao;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.akhitev.kb.spring.hibernate.entity.CommandRank;

import java.util.List;

@Repository
@Transactional
public class CommandRankDao {
    private static Logger logger = LoggerFactory.getLogger(CommandRankDao.class);
    private SessionFactory sessionFactory;

    @Autowired
    public CommandRankDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<CommandRank> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from CommandRank cr").list();
    }
}
