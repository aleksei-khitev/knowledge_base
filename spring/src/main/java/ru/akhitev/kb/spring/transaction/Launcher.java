package ru.akhitev.kb.spring.transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.akhitev.kb.spring.transaction.conf.DbConf;
import ru.akhitev.kb.spring.transaction.service.FleetService;

public class Launcher {
    private static Logger logger = LoggerFactory.getLogger(Launcher.class);
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DbConf.class);
        FleetService fleetService = context.getBean(FleetService.class);
        fleetService.fleetUnitById(11L).ifPresent(unit -> logger.info(unit.toMultiLineString()));
    }
}
