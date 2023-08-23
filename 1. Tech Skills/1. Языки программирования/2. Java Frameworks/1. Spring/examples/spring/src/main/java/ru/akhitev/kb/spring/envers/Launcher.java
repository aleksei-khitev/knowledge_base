package ru.akhitev.kb.spring.envers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.akhitev.kb.spring.envers.conf.DbConf;
import ru.akhitev.kb.spring.envers.entity.Ship;
import ru.akhitev.kb.spring.envers.service.ShipService;

public class Launcher {
    private static Logger logger = LoggerFactory.getLogger(Launcher.class);

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DbConf.class);

        ShipService shipService = context.getBean(ShipService.class);
        Ship ship = new Ship();
        ship.setType("aaaa");
        ship.setShipClass("bbbb");
        ship.setLink("cccc");
        shipService.save(ship);
        ship.setShipClass("arrrrv");
        shipService.save(ship);
        logger.info("Actual value: {}", shipService.getById(ship.getId()));
        logger.info("Value of revision 1: {}", shipService.findShipByRevision(ship.getId(), 1));
    }
}
