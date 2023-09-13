package Main.Strategies.SpotAssignment;

import Main.Models.ParkingLot;
import Main.Models.ParkingSpot;
import Main.Models.VehicleType;

public interface SpotAssignmentStrategy {

    public ParkingSpot assignSpot(ParkingLot parkingLot , VehicleType vehicleType);
}
