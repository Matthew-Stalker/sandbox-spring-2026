package org.example.sandbox.inheritance;

import java.util.ArrayList;
import java.util.List;
public class Driver {

    public static void main(String[] args) {
        Vehicle car =  new Car();
        Vehicle truck = new Truck();
        System.out.println("Number of Vehicles: " + Vehicle.getCounter());

        car.setLoadCapacity(4000);
        truck.setLoadCapacity(8000);

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(truck);

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getClass().getSimpleName() + " load capacity: " + vehicle.getLoadCapacity());
            vehicle.load();
        }

        car.unload();
        truck.unload();

    }
}
