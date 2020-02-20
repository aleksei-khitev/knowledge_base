package ru.akhitev.kb.spring.hibernate.dao;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class StateDaoSpec {
    private static Logger logger = LoggerFactory.getLogger(StateDaoSpec.class);
    private StateDao dao;

    @Before
    public void setUp() {
        ApplicationContext context = new GenericXmlApplicationContext("spring/hibernate/beans.xml");
        dao = context.getBean(StateDao.class);
    }

    @Test
    public void when_findAll_then_findAll() {
        logger.info("All states: {}", dao.findAll());
    }
}
