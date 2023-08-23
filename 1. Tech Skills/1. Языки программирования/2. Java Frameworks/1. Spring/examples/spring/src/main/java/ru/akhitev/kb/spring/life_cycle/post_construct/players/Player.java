package ru.akhitev.kb.spring.life_cycle.post_construct.players;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

public class Player {
    private String role;
    private boolean ready;

    public Player(String role) {
        this.role = role;
    }

    @PostConstruct
    private void initialize() throws InterruptedException {
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
