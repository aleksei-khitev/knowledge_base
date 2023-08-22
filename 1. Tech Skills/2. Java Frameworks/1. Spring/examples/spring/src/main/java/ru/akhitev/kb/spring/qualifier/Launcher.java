package ru.akhitev.kb.spring.qualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Launcher.class)
public class Launcher {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Launcher.class);
        PatrolMission mission = context.getBean(PatrolMission.class);
        System.out.println(mission);
    }
}
