package ru.akhitev.kb.spring_boot.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Greetings {
    private static Logger logger = LoggerFactory.getLogger(Greetings.class);

    public void greet() {
        logger.info("Hey");
    }
}
