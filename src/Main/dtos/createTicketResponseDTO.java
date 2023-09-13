package Main.dtos;

import Main.Models.Ticket;

public class createTicketResponseDTO {
    private Ticket ticket;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
