package ru.akhitev.kb.spring.java_config;

import org.springframework.beans.factory.BeanNameAware;

public class Terminator implements BeanNameAware, Guest {
    private String name;

    public void reply() {
        System.out.println(name + ": Fuck you asshole");
    }

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }
}
