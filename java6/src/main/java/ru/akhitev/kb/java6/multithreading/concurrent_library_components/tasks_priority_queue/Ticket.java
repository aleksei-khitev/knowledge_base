package ru.akhitev.kb.java6.multithreading.concurrent_library_components.tasks_priority_queue;

import java.util.Comparator;

class Ticket implements Comparable<Ticket> {
    private final int key;
    private final String name;
    private final TicketPriority priority;
    private TicketStatus status;

    Ticket(int key, String name, TicketPriority priority) {
        this.key = key;
        this.name = name;
        this.priority = priority;
        status = TicketStatus.OPENED;
    }

    void setStatus(TicketStatus status) { this.status = status; }

    TicketPriority getPriority() { return priority; }

    @Override
    public String toString() {
        return "Ticket{key=" + key + ", name='" + name + '\'' +
                ", priority=" + priority + ", status=" + status + '}'; }

    @Override
    public int compareTo(Ticket o) {
        return Comparator.comparing(Ticket::getPriority).reversed()
                .compare(this, o);
    }
}
