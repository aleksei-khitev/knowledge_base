package ru.akhitev.kb.spring.profiles.java_configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ru.akhitev.kb.spring.profiles.BrothersMmoPair;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Profile("ВКО")
public class Vko {
    @Bean
    public BrothersMmoPair brothersMmoPair() {
        List<String> pair = new ArrayList<>();
        pair.add("Кон");
        pair.add("Эндемеон");
        return new BrothersMmoPair("Властелин колец онлайн", pair);
    }
}
