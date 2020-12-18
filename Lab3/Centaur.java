package Vehicle.GroundVehicle;

import Vehicle.Types.GroundVehicle;

public class Centaur extends GroundVehicle {

    public Centaur() {
        super("Centaur", 15);
        restInterval = 8;
    }
    
    @Override
    protected double restTime(int count) {
        return 2;
    }
}
