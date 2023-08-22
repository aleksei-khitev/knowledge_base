package ru.akhitev.kb.spring.life_cycle.bean_name_aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;

public class User implements BeanNameAware, InitializingBean {
    private String name;

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Good day " + name + "!!!!");
    }
}
