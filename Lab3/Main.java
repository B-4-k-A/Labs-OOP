import Race.Race;
import Vehicle.AirVehicle.*;
import Vehicle.GroundVehicle.*;
import Vehicle.Types.TypeOfRace;

public class Main {
    public static void main(String[] argv) {
        Race airRace = new Race(TypeOfRace.RaceForAirVehicle, 100000);
        Race groundRace = new Race(TypeOfRace.RaceForGroundVehicle, 100000);
        Race raceForAny = new Race(TypeOfRace.RaceForAnyVehicle, 100000);

        airRace.addVehicle(new Broom());
        airRace.addVehicle(new MagicCarpet());
        airRace.addVehicle(new Stupa());
        // airRace.run();

        groundRace.addVehicle(new AllTerrainBoots());
        groundRace.addVehicle(new BactrianCamel());
        groundRace.addVehicle(new Centaur());
        groundRace.addVehicle(new SpeedCamel());
        // groundRace.run();

        raceForAny.addVehicle(new Broom());
        raceForAny.addVehicle(new MagicCarpet());
        raceForAny.addVehicle(new Stupa());
        raceForAny.addVehicle(new AllTerrainBoots());
        raceForAny.addVehicle(new Centaur());
        raceForAny.addVehicle(new SpeedCamel());
        raceForAny.addVehicle(new BactrianCamel());
        raceForAny.run();

    }
}