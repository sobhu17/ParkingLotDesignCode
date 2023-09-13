package Main.dtos;

import Main.Models.Gate;
import Main.Models.Vehicle;

public class createTicketRequestDTO {
    private Gate gate;
    private Vehicle vehicle;

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
