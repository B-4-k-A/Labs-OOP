package Vehicle.Types;

public abstract class Vehicle {
    private final String name;
    private final double speed;
    private final TypeOfRace type;

    protected Vehicle(String name, double speed, TypeOfRace type) {
        this.name = name;
        this.speed = speed;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public TypeOfRace getType() {
        return type;
    }

    public abstract double getTimeOfRace(double distance);
}
