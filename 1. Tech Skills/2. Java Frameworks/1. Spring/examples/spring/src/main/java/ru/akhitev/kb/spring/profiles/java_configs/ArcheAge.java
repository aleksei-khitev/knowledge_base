package ru.akhitev.kb.spring.profiles.java_configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ru.akhitev.kb.spring.profiles.BrothersMmoPair;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Profile("archeAge")
public class ArcheAge {
    @Bean
    public BrothersMmoPair brothersMmoPair() {
        List<String> pair = new ArrayList<>();
        pair.add("Kon");
        pair.add("Endemeon");
        return new BrothersMmoPair("Arche Age", pair);
    }
}
