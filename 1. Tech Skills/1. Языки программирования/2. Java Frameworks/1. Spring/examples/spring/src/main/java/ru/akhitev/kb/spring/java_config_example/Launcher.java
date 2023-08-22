package ru.akhitev.kb.spring.java_config_example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.akhitev.kb.spring.java_config_example.servicies.PlanetDetails;

public class Launcher {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MapConfig.class);
        PlanetDetails planetDetails = context.getBean(PlanetDetails.class);
        System.out.println(planetDetails.planetInfo());
        System.out.println(planetDetails.reportDateTime());
    }
}
