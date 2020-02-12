package ru.akhitev.kb.spring.life_cycle.bean_name_aware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Launcher {
    @Bean(name = "Kon65")
    public User user() {
        return new User();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Launcher.class);
        context.getBean(User.class);
    }
}
