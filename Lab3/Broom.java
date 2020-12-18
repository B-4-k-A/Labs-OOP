package Vehicle.AirVehicle;

import java.util.ArrayList;

import Vehicle.Types.AirVehicle;

public class Broom extends AirVehicle {

    public Broom() {
        super("Broom", 20);
    }
    
    @Override
    protected double distanceReducer(double distance) {
        ArrayList<Double> temp = calc(distance);
        return 1000 * temp.get(0) + temp.get(1);

    }

    private ArrayList<Double> calc(double distance) {
        ArrayList<Double> temp = new ArrayList<>();
        int i = 0;
        while(distance > 1000) { 
            distance = (distance - 1000) * 0.99;
            i++;
        }
        temp.add((double)i);
        temp.add(distance);
        return temp;
    }
}