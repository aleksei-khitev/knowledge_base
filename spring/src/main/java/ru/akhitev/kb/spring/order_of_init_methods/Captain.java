package ru.akhitev.kb.spring.order_of_init_methods;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Captain implements InitializingBean, DisposableBean {
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

    public void deconstruct() {
        System.out.println("3. Travel to a Bank");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("2. Roll valuable items from boss chest");
    }

    @PreDestroy
    private void deconstructing() {
        System.out.println("1. Wear lucky horseshoe");
    }
}
