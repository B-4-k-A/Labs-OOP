package Race;

import java.util.ArrayList;
import java.util.HashMap;

import Vehicle.Types.TypeOfRace;
import Vehicle.Types.Vehicle;

public class Race {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    TypeOfRace type;
    double distance;

    public Race(TypeOfRace type, double distance) {
        this.type = type;
        this.distance = distance;
    }

    public void addVehicle(Vehicle vehicle) {
        if (type == TypeOfRace.RaceForAnyVehicle || type == vehicle.getType()) {
            vehicles.add(vehicle);
        } else {
            throw new RuntimeException("Uncorrect type of vehicle for " + type);
        }
    }

    public void run() {
        HashMap<Double, String> results = new HashMap<>();
        ArrayList<Double> res = new ArrayList<>();
        System.out.println("Vehicles participate in race:");
        for (Vehicle veh : vehicles) {
            double time = veh.getTimeOfRace(distance);
            results.put(time, veh.getName());
            res.add(time);
            System.out.println("\t" + veh.getName());
        }
        res.sort(null);
        System.out.println("Winner:");
        System.out.println("\tName\tTime");
        System.out.printf("\t%s\t%.2f\n", results.get(res.get(0)), res.get(0));
    }
}