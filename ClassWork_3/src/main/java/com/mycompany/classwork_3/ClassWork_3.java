
package com.mycompany.classwork_3;

import java.util.ArrayList;
public class ClassWork_3 {

    public static void main(String[] args) {
         ArrayList<Vehicle> vehicles = new ArrayList<>();

        Car car1 = new Car("Toyota", "Axio", 2200000, "Silver", 5);
        Car car2 = new Car("Mitsubishi", "Outlander", 4500000, "White", 7);

        Motorcycle bike1 = new Motorcycle("Yamaha", "FZS FI V3", 265000, "Blue", "150cc");
        Motorcycle bike2 = new Motorcycle("Bajaj", "Pulsar 150", 200000, "Red", "150cc");

        vehicles.add(car1);
        vehicles.add(car2);
        vehicles.add(bike1);
        vehicles.add(bike2);

        System.out.println("Vehicle Information :\n");

        for (Vehicle v : vehicles) {
            v.displayInfo();
        }
    }
}
