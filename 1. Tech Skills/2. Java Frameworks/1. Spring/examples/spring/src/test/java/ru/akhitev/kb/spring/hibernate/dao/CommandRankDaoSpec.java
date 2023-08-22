package ru.akhitev.kb.spring.hibernate.dao;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.akhitev.kb.spring.hibernate.entity.CommandRank;

import java.util.List;

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

    @Test
    public void when_saveNew_then_generatedId() {
        CommandRank commandRank = new CommandRank();
        commandRank.setName("Адмирал");
        dao.save(commandRank);
        System.out.println("commandRank.getId() = " + commandRank.getId());
    }

    @Test
    public void when_delete_then_subCollectionsDelete() {
        List<CommandRank> commandRankList = dao.findAll();
        logger.info("Before delete: {}", commandRankList);
        CommandRank commandRank = commandRankList.get(0);
        dao.delete(commandRank);
        logger.info("Before delete: {}", dao.findAll());
    }

}
