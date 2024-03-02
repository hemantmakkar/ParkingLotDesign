package floor;

import java.util.ArrayList;
import java.util.List;

public class FloorDAO {
    private static final List<Floor> floors = new ArrayList<Floor>();

    public void addFloor(Floor floor) {
        this.floors.add(floor);
    }

    public List<Floor> getAllFloors() {
        return this.floors;
    }
}
