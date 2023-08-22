package ru.akhitev.kb.spring_boot.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.akhitev.kb.spring_boot.jpa.repo.FleetUnitRepo;
import ru.akhitev.kb.spring_boot.jpa.repo.ShipRepo;

@SpringBootApplication(scanBasePackageClasses = Application.class)
public class Application implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private FleetUnitRepo fleetUnitRepo;

    @Autowired
    private ShipRepo shipRepo;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("fleet units: {}", fleetUnitRepo.findAll());
        logger.info("ships: {}", shipRepo.findAll());
    }
}
