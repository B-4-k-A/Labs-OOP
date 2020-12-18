package Vehicle.Types;

public abstract class GroundVehicle extends Vehicle {

    protected double restInterval;

    protected GroundVehicle(String name, double speed) {
        super(name, speed, TypeOfRace.RaceForGroundVehicle);
    }

    @Override
    public double getTimeOfRace(double distance) {
        return (distance / getSpeed()) + sumOfRestTimeForAllDistanse(distance);
    }

    protected double sumOfRestTimeForAllDistanse(double distance) {
        double sum = 0;
        int countOfRest = (int) (distance / restInterval);
        for (int i = 1; i <= countOfRest; i++) {
            sum += restTime(i);
        }
        return sum;
    }

    protected abstract double restTime(int count);
}
