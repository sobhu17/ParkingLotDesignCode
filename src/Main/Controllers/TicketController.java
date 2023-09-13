package Main.Controllers;

import Main.Models.Ticket;
import Main.Services.TicketService;
import Main.dtos.createTicketRequestDTO;
import Main.dtos.createTicketResponseDTO;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public createTicketResponseDTO createTicket(createTicketRequestDTO request){
        Ticket ticket = ticketService.createTicket(
                request.getGate(),
                request.getVehicle()
        );

        createTicketResponseDTO response = new createTicketResponseDTO();
        response.setTicket(ticket);

        return response;
    }
}
