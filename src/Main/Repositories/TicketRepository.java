package Main.Repositories;

import Main.Models.Ticket;

import java.util.HashMap;

public class TicketRepository {
    private HashMap<Long , Ticket> map = new HashMap<>();
    private long lastIdCount = 0;

    public Ticket save(Ticket ticket){
        lastIdCount = lastIdCount + 1;
        ticket.setId(lastIdCount);
        map.put(lastIdCount , ticket);
        return ticket;
    }
}
