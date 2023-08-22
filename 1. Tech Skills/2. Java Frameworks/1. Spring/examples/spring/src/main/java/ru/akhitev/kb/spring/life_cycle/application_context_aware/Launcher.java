package ru.akhitev.kb.spring.life_cycle.application_context_aware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Launcher {
    @Bean
    public Rule weekEndRule() {
        return new Rule();
    }

    @Bean
    public Rule workingDayRule() {
        return new Rule();
    }

    @Bean
    public RobotCleanerLauncher cleanerLauncher() {
        return new RobotCleanerLauncher();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Launcher.class);
        RobotCleanerLauncher cleanerLauncher = context.getBean(RobotCleanerLauncher.class);
        System.out.println(cleanerLauncher.whatSchedulerToday());
    }
}
