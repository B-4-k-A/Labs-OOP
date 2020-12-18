package Vehicle.AirVehicle;

import Vehicle.Types.AirVehicle;

public class Stupa extends AirVehicle {
    
    public Stupa() {
        super("Stupa", 8);
    }

    @Override 
    protected double distanceReducer(double distanse) {
        return distanse * 0.94;
    }
}
