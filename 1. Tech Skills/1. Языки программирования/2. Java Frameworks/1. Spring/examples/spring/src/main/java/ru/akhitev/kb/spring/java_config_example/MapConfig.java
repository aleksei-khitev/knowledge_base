package ru.akhitev.kb.spring.java_config_example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.time.LocalDateTime;

@Configuration
@ImportResource("spring/java_config_example/beans.xml")
public class MapConfig {

    @Bean
    public LocalDateTime appLaunchDateTime() {
        return LocalDateTime.now();
    }
}
