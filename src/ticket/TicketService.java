package ticket;

import floor.Floor;
import vehicle.Vehicle;
import vehicle.VehicleType;

import java.util.TreeSet;
import java.util.UUID;

public class TicketService {
    private final TicketDAO ticketDAO;
    public TicketService(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }
    public UUID createTicket(Vehicle v, Floor f) {
        if (f == null) {
            System.out.println("Parking Lot Full");
            return null;
        }

        TreeSet<Integer> set = f.getFreeSlotsForVehicleType(v.getType());
        int slot = set.pollFirst();

        f.addSlotsForVehicleType(v.getType(), set);

        TreeSet<Integer> set2 = f.getOccSlotsForVehicleType(v.getType());
        set2.add(slot);
        f.addOccSlotsForVehicleType(v.getType(), set2);

        Ticket t = new Ticket(UUID.randomUUID(), f, v, slot);
        ticketDAO.addTicket(t.getId(), t);

        System.out.println("Parked vehicle. Ticket ID: " + t.getId());
        return t.getId();
    }

    public void removeTicket(UUID id) {
        Ticket t = ticketDAO.getTicket(id);

        if(t == null) {
            System.out.println("Invalid Ticket");
            return;
        }

        Floor f = t.getFloor();
        Vehicle v = t.getVehicle();
        int slot = t.getSlot();

//        if(v.getType() == VehicleType.CAR) System.out.println(slot);

        TreeSet<Integer> set = f.getOccSlotsForVehicleType(v.getType());
        set.remove(slot);
        f.addOccSlotsForVehicleType(v.getType(), set);

        TreeSet<Integer> set2 = f.getFreeSlotsForVehicleType(v.getType());
        set2.add(slot);
        f.addSlotsForVehicleType(v.getType(), set2);

        System.out.println("Unparked vehicle with Registration Number: " + v.getRegNo() + " and Color: " + v.getColor());
    }
}