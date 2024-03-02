package floor;

import vehicle.VehicleType;

import java.util.List;
import java.util.TreeSet;

public class FloorService {
    private final FloorDAO floorDAO;
    public FloorService(FloorDAO floorDAO) {
        this.floorDAO = floorDAO;
    }

    public void createFloors(int noOfFloors, int totalSlots) {
        for(int i=1 ; i<=noOfFloors ; i++) {
            createFloor(i, totalSlots);
        }

        System.out.println("Created parking lot with " + noOfFloors + " floors and " + totalSlots + " slots per floor");
    }

    public void createFloor(int id, int totalSlots) {
        int truckSlots = 1;
        int bikeSlots = 2;
        int carSlots = totalSlots - truckSlots - bikeSlots;

        Floor f = new Floor(id);
        floorDAO.addFloor(f);

        TreeSet<Integer> s1 = allocateSlots(1, 1);
        f.addSlotsForVehicleType(VehicleType.TRUCK, s1);

        TreeSet<Integer> s2 = allocateSlots(2, 2);
        f.addSlotsForVehicleType(VehicleType.BIKE, s2);

        TreeSet<Integer> s3 = allocateSlots(carSlots, 4);
        f.addSlotsForVehicleType(VehicleType.CAR, s3);

        f.addOccSlotsForVehicleType(VehicleType.CAR, new TreeSet<>());
        f.addOccSlotsForVehicleType(VehicleType.BIKE, new TreeSet<>());
        f.addOccSlotsForVehicleType(VehicleType.TRUCK, new TreeSet<>());
    }

    private TreeSet<Integer> allocateSlots(int numSlots, int idx) {
        TreeSet<Integer> slots = new TreeSet();
        for (int i = 0; i < numSlots; i++) {
            slots.add(idx++);
        }
        return slots;
    }

    public void displayFreeSlots(VehicleType vt) {
        List<Floor> floors = floorDAO.getAllFloors();
        for(Floor f : floors) {
            TreeSet<Integer> set = f.getFreeSlotsForVehicleType(vt);
            System.out.println("Free slots for " + vt + " on Floor " + f.getId() + ": " + set.toString());
        }
    }

    public void displayFreeCount(VehicleType vt) {
        List<Floor> floors = floorDAO.getAllFloors();
        for(Floor f : floors) {
            TreeSet<Integer> set = f.getFreeSlotsForVehicleType(vt);
            System.out.println("No. of free slots for " + vt + " on Floor " + f.getId() + ": " + set.size());
        }
    }

    public void displayOccSlots(VehicleType vt) {
        List<Floor> floors = floorDAO.getAllFloors();
        for(Floor f : floors) {
            TreeSet<Integer> set = f.getOccSlotsForVehicleType(vt);
            System.out.println("Occ slots for " + vt + " on Floor " + f.getId() + ": " + set.toString());
        }
    }

    public Floor floorInWhichFreeSlotAvailable(VehicleType vt) {
        List<Floor> floors = floorDAO.getAllFloors();
        for(Floor f : floors) {
            TreeSet<Integer> set = f.getFreeSlotsForVehicleType(vt);
            if(set.size() != 0) return f;
        }
        return null;
    }
}