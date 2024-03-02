package floor;

import vehicle.VehicleType;

import java.util.HashMap;
import java.util.TreeSet;
import java.util.Map;
import java.util.UUID;

public class Floor {
    private int id;
    private Map<VehicleType, TreeSet<Integer>> totalSlots;
    private Map<VehicleType, TreeSet<Integer>> occSlots;

    public void addSlotsForVehicleType(VehicleType type, TreeSet<Integer> set) {
        totalSlots.put(type, set);
    }

    public Floor(int id) {
        this.id = id;
        this.totalSlots = new HashMap<>();
        this.occSlots = new HashMap<>();
    }

    public TreeSet<Integer> getFreeSlotsForVehicleType(VehicleType type) {
        return totalSlots.get(type);
    }

    public TreeSet<Integer> getOccSlotsForVehicleType(VehicleType type) {
        return occSlots.get(type);
    }

    public int getId() {
        return id;
    }

    public void addOccSlotsForVehicleType(VehicleType type, TreeSet<Integer> set) {
        occSlots.put(type, set);
    }
}