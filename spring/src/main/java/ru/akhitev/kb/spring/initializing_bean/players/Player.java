package ru.akhitev.kb.spring.initializing_bean.players;

import org.springframework.beans.factory.InitializingBean;

import java.util.concurrent.TimeUnit;

public class Player implements InitializingBean {
    private String role;
    private boolean ready;

    public Player(String role) {
        this.role = role;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(role + " changing skills, sets and portions");
        TimeUnit.MILLISECONDS.sleep(100);
        ready = true;
        System.out.println(role + " is ready");
    }

    @Override
    public String toString() {
        return role + (ready ? " is ready" : " is not ready yet");
    }
}
