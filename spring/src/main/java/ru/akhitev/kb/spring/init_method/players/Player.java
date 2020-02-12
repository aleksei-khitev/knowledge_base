package ru.akhitev.kb.spring.init_method.players;

import java.util.concurrent.TimeUnit;

public class Player {
    private String role;
    private boolean ready;

    public Player(String role) throws InterruptedException {
        this.role = role;
        TimeUnit.MILLISECONDS.sleep(100);
        ready = true;
    }

    @Override
    public String toString() {
        return role + (ready ? " is ready" : " is not ready yet");
    }
}
