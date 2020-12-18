package Vehicle.AirVehicle;

import Vehicle.Types.AirVehicle;

public class MagicCarpet extends AirVehicle {

    public MagicCarpet() {
        super("MagicCarpet", 10);
    }

    @Override
    protected double distanceReducer(double distance) {
        if (distance < 1000) {
            return distance;
        } else if (distance < 5000) {
            return distance * 0.97;
        } else if (distance < 10000) {
            return distance * 0.90;
        } else {
            return distance * 0.95;
        }
    }
}
