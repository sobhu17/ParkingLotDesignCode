package Main.Services;

import Main.Models.*;
import Main.Repositories.ParkingLotRepository;
import Main.Repositories.ParkingSpotRepository;
import Main.Repositories.TicketRepository;
import Main.Strategies.SpotAssignment.SpotAssignmentStrategy;
import Main.dtos.createTicketRequestDTO;

import java.util.Date;

public class TicketService {
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingLotRepository parkingLotRepository;
    private ParkingSpotRepository parkingSpotRepository;
    private TicketRepository ticketRepository;

    public TicketService(SpotAssignmentStrategy spotAssignmentStrategy ,
                         ParkingLotRepository parkingLotRepository ,
                         ParkingSpotRepository parkingSpotRepository,
                         TicketRepository ticketRepository){
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingSpotRepository  =parkingSpotRepository;
        this.ticketRepository = ticketRepository;
    }


    public Ticket createTicket(Gate gate , Vehicle vehicle){
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
        ticket.setGate(gate);
        ticket.setVehicle(vehicle);
        ticket.setOperator(gate.getOperator());

        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(parkingLotRepository.getParkingLotForGate(gate), vehicle.getVehicleType());

        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
        parkingSpotRepository.save(parkingSpot);

        ticket.setParkingSpot(parkingSpot);

        return ticketRepository.save(ticket);
    }
}
