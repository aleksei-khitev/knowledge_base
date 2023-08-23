package ru.akhitev.kb.spring.life_cycle.application_context_aware;

import org.springframework.beans.factory.BeanNameAware;

public class Rule implements BeanNameAware {
    private String name;

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
