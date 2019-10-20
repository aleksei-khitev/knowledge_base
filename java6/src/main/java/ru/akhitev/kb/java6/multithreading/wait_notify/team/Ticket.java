package ru.akhitev.kb.java6.multithreading.wait_notify.team;

public class Ticket {
    private final int ticketNumber;

    public Ticket(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @Override
    public String toString() {
        return "Ticket{ticketNumber=" + ticketNumber + '}';
    }
}
