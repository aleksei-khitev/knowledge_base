package threads.producers_consumers.team_multiple_queues;

class Ticket {
    private final int ticketNumber;
    private TicketState state;

    Ticket(int ticketNumber) {
        this.ticketNumber = ticketNumber;
        state = TicketState.OPEN;
    }

    void setState(TicketState state) { this.state = state; }

    @Override
    public String toString() {
        return "Ticket{ticketNumber=" + ticketNumber + ", state=" + state + '}';
    }
}
