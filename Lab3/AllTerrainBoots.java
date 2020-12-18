package Vehicle.GroundVehicle;

import Vehicle.Types.GroundVehicle;

public class AllTerrainBoots extends GroundVehicle {
    
    public AllTerrainBoots() {
        super("AllTerrainsBoots", 6);
        restInterval = 60;
    }

    @Override
    protected double restTime(int count) {
        switch (count) {
            case 1:
            return 10;
            default:
            return 5;
        }
    }
}
