package Main.Models;

import java.util.List;

public class ParkingFloor extends BaseModel{
    private List<ParkingSpot> parkingSpots;
    private long number;

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}
