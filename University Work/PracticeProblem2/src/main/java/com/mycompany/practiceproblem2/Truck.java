
package com.mycompany.practiceproblem2;

public class Truck extends Vehicle implements Engine, CargoCarrier {

    private double maxLoad;

    public Truck(String model, int year, double maxLoad) {
        super(model, year);
        this.maxLoad = maxLoad;
    }

    @Override
    public void startEngine() {
        System.out.println(model + " engine started with heavy-duty starter.");
    }

    @Override
    public double getMaxLoad() {
        return maxLoad;
    }

    @Override
    public void displayDetails() {
        System.out.println("Truck: " + model + " | Year: " + year +
                " | Max Load: " + maxLoad + " tons");
    }
}
