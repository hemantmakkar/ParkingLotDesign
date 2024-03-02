import floor.FloorDAO;
import floor.FloorService;
import ticket.TicketDAO;
import ticket.TicketService;
import vehicle.Vehicle;
import vehicle.VehicleType;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        FloorDAO floorDAO = new FloorDAO();
        FloorService floorService = new FloorService(floorDAO);

        floorService.createFloors(2, 6);

        floorService.displayFreeSlots(VehicleType.TRUCK);
        floorService.displayFreeSlots(VehicleType.BIKE);
        floorService.displayFreeSlots(VehicleType.CAR);

        floorService.displayFreeCount(VehicleType.TRUCK);
        floorService.displayFreeCount(VehicleType.BIKE);
        floorService.displayFreeCount(VehicleType.CAR);

        floorService.displayOccSlots(VehicleType.CAR);

        Vehicle v1 = new Vehicle("BLACK", "KA-01-DB-1234", VehicleType.CAR);
        Vehicle v2 = new Vehicle("WHITE", "KA-01-DB-2345", VehicleType.TRUCK);
        Vehicle v3 = new Vehicle("GREY", "KA-01-DB-2346", VehicleType.TRUCK);
        Vehicle v4 = new Vehicle("BLUE", "KA-01-DB-2347", VehicleType.TRUCK);
        Vehicle v5 = new Vehicle("ORANGE", "KA-01-DB-1235", VehicleType.CAR);
        Vehicle v6 = new Vehicle("BLACK", "KA-01-DB-3456", VehicleType.BIKE);
        Vehicle v7 = new Vehicle("BLUE", "KA-01-DB-3457", VehicleType.BIKE);
        Vehicle v8 = new Vehicle("GREEN", "KA-01-DB-3458", VehicleType.BIKE);

        TicketDAO ticketDAO = new TicketDAO();
        TicketService ticketService = new TicketService(ticketDAO);

        UUID t1 = ticketService.createTicket(v1, floorService.floorInWhichFreeSlotAvailable(v1.getType()));
        UUID t2 = ticketService.createTicket(v2, floorService.floorInWhichFreeSlotAvailable(v2.getType()));
        UUID t3 = ticketService.createTicket(v3, floorService.floorInWhichFreeSlotAvailable(v3.getType()));
        UUID t4 = ticketService.createTicket(v4, floorService.floorInWhichFreeSlotAvailable(v4.getType()));

        floorService.displayFreeSlots(VehicleType.TRUCK);
        floorService.displayOccSlots(VehicleType.TRUCK);

        UUID t5 = ticketService.createTicket(v5, floorService.floorInWhichFreeSlotAvailable(v5.getType()));

        floorService.displayFreeSlots(VehicleType.CAR);
        floorService.displayOccSlots(VehicleType.CAR);

        UUID t6 = ticketService.createTicket(v6, floorService.floorInWhichFreeSlotAvailable(v6.getType()));
        UUID t7 = ticketService.createTicket(v7, floorService.floorInWhichFreeSlotAvailable(v7.getType()));
        UUID t8 = ticketService.createTicket(v8, floorService.floorInWhichFreeSlotAvailable(v8.getType()));

        ticketService.removeTicket(t2);

        floorService.displayFreeSlots(VehicleType.TRUCK);
        floorService.displayOccSlots(VehicleType.TRUCK);

        ticketService.removeTicket(UUID.randomUUID());

        ticketService.removeTicket(t1);

        floorService.displayFreeSlots(VehicleType.CAR);
        floorService.displayOccSlots(VehicleType.CAR);

    }
}