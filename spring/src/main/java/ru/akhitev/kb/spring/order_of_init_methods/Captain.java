package ru.akhitev.kb.spring.order_of_init_methods;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

public class Captain implements InitializingBean {
    public void init() {
        System.out.println("3. Use buff skills");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("2. Eat food with regeneration and stats buffs");
    }

    @PostConstruct
    public void initializing() {
        System.out.println("1. Check skills, set and weapon");
    }
}
