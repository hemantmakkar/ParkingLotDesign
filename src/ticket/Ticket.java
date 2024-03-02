package ticket;

import floor.Floor;
import vehicle.Vehicle;

import java.util.UUID;

public class Ticket {
    private UUID id;
    private Floor floor;
    private Vehicle vehicle;
    private int slot;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getSlot() {
        return slot;
    }

    public UUID getId() {
        return id;
    }

    public Floor getFloor() {
        return floor;
    }

    public Ticket(UUID id, Floor floor, Vehicle vehicle, int slot) {
        this.id = id;
        this.floor = floor;
        this.vehicle = vehicle;
        this.slot = slot;
    }
}
