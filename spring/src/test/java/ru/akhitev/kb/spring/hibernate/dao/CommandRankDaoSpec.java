package ru.akhitev.kb.spring.hibernate.dao;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CommandRankDaoSpec {
    private static Logger logger = LoggerFactory.getLogger(CommandRankDaoSpec.class);
    private CommandRankDao dao;

    @Before
    public void setUp() {
        ApplicationContext context = new GenericXmlApplicationContext("spring/hibernate/beans.xml");
        dao = context.getBean(CommandRankDao.class);
    }

    @Test
    public void when_findAll_then_findAll() {
        logger.info("All states: {}", dao.findAll());
    }
}
