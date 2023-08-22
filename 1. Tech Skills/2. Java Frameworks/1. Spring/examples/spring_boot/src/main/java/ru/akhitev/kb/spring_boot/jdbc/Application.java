package ru.akhitev.kb.spring_boot.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.akhitev.kb.spring_boot.jdbc.dao.Dao;
import ru.akhitev.kb.spring_boot.jdbc.dao.FleetUnitDao;
import ru.akhitev.kb.spring_boot.jdbc.dao.ShipDao;
import ru.akhitev.kb.spring_boot.jdbc.entity.FleetUnit;
import ru.akhitev.kb.spring_boot.jdbc.entity.Ship;

@SpringBootApplication(scanBasePackageClasses = Application.class)
public class Application {
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        assert (context != null);

        Dao<FleetUnit> fleetUnitDao = context.getBean(FleetUnitDao.class);
        logger.info("Fleet units: {}", fleetUnitDao.findAll());

        Dao<Ship> shipDao = context.getBean(ShipDao.class);
        logger.info("Ships: {}", shipDao.findAll());
    }
}
