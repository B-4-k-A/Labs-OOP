package Vehicle.GroundVehicle;

import Vehicle.Types.GroundVehicle;

public class SpeedCamel extends GroundVehicle {

    public SpeedCamel() {
        super("SpeedCamel", 40);
        restInterval = 10;
    }

    protected double restTime(int count) {
        switch (count) {
            case 1:
            return 5;
            case 2:
            return 6.5;
            default:
            return 8;
        }
    }
}
