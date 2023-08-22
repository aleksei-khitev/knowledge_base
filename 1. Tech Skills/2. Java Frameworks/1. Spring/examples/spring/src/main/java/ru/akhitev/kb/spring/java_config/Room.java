package ru.akhitev.kb.spring.java_config;

public class Room {
    private Guest guest;

    public void askIfEverythingOk() {
        System.out.println("Are you Ok?");
        guest.reply();
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
}
