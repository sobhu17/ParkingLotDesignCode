package Main;

import Main.Controllers.TicketController;
import Main.Models.Ticket;
import Main.Repositories.ParkingLotRepository;
import Main.Repositories.ParkingSpotRepository;
import Main.Repositories.TicketRepository;
import Main.Services.TicketService;
import Main.Strategies.SpotAssignment.RandomSpotAssignmentStrategy;
import Main.Strategies.SpotAssignment.SpotAssignmentStrategy;
import Main.dtos.createTicketRequestDTO;
import Main.dtos.createTicketResponseDTO;

public class ParkingLotMain {
    public static void main(String[] args) {
        ObjectRegistry objectRegistry = new ObjectRegistry();

        objectRegistry.register(
                "parkingLotRepository",
                new ParkingLotRepository()
        );
        objectRegistry.register(
                "parkingSpotRepository",
                new ParkingSpotRepository()
        );
        objectRegistry.register(
                "ticketRepository",
                new TicketRepository()
        );
        objectRegistry.register(
                "spotAssignmentStrategy",
                new RandomSpotAssignmentStrategy()
        );

        objectRegistry.register("ticketService",
                new TicketService(
                        (SpotAssignmentStrategy) objectRegistry.get("spotAssignmentStrategy"),
                        (ParkingLotRepository) objectRegistry.get("parkingLotRepository"),
                        (ParkingSpotRepository) objectRegistry.get("parkingSpotRepository"),
                        (TicketRepository) objectRegistry.get("ticketRepository")
                ));

        objectRegistry.register(
                "ticketController",
                new TicketController(
                        (TicketService) objectRegistry.get("ticketService")
                )
        );


        createTicketRequestDTO request = new createTicketRequestDTO();
        request.setGate(null);
        request.setVehicle(null);

        createTicketResponseDTO response = ((TicketController)objectRegistry.get("ticketController")).createTicket(request);

        System.out.println("Hello!! Your ticket is created... Now you can park the Vehicle!!!");
    }
}
