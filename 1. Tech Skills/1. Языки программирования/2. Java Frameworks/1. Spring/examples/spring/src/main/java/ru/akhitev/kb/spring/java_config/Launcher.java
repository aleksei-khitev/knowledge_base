package ru.akhitev.kb.spring.java_config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Launcher {
    @Bean
    public Terminator terminator() { return new Terminator(); }

    @Bean
    public Room hotelRoom() {
        Room room = new Room();
        room.setGuest(terminator());
        return room;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Launcher.class);
        context.getBean(Room.class).askIfEverythingOk();
    }
}
