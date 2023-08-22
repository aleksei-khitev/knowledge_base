package ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.DbConfig;
import ru.akhitev.kb.spring.jdbc_spring.jdbc_template_dao_repostiroy.dao.ship.ShipDao;
import ru.akhitev.kb.spring.jdbc_spring.plain_dao.entity.Ship;

import java.util.List;

public class ShipDaoSpec {
    private static Logger logger = LoggerFactory.getLogger(ShipDaoSpec.class);
    private ShipDao dao;

    @Before
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
        dao = context.getBean(ShipDao.class);
    }

    @Test
    public void having_existingShip_when_findNameById_then_return_Name() {
        String name = dao.findNameById(1L);
        Assert.assertNotNull(name);
        logger.info("name = {}", name);
        Assert.assertEquals("101", name);
    }

    @Test
    public void having_shipsDao_when_findAll_then_return_allShips() {
        List<Ship> ships = dao.findAll();
        Assert.assertNotNull(ships);
        logger.info("ships = {}", ships);
    }
}
