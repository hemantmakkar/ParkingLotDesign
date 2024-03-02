package vehicle;

public class Vehicle {
    private String color;
    private String regNo;
    private VehicleType type;

    public Vehicle(String color, String regNo, VehicleType type) {
        this.color = color;
        this.regNo = regNo;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public String getRegNo() {
        return regNo;
    }

    public VehicleType getType() {
        return type;
    }
}
