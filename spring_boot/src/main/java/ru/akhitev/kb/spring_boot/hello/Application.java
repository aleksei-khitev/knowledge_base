package ru.akhitev.kb.spring_boot.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Application {
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        assert (context != null);
        logger.info("Компоненты в контексте:");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(logger::info);
        logger.info("========");
        context.getBean(Greetings.class).greet();
        context.close();
    }
}
