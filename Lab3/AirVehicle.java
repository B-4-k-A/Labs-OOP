package Vehicle.Types;

public abstract class AirVehicle extends Vehicle {

    protected AirVehicle(String name, double speed) {
        super(name, speed, TypeOfRace.RaceForAirVehicle);
    }

    protected abstract double distanceReducer(double distance);

    @Override
    public double getTimeOfRace(double distance) {
        return distanceReducer(distance) / getSpeed();
    }
}
