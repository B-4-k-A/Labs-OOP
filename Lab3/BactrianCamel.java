package Vehicle.GroundVehicle;

import Vehicle.Types.GroundVehicle;

public class BactrianCamel extends GroundVehicle {
    
    public BactrianCamel() {
        super("BacrianCamel", 10);
        restInterval = 30;
    }

    @Override
    protected double restTime(int count) {
        switch (count) {
            case 1:
            return 5;
            default:
            return 8;
        }
    }
}
