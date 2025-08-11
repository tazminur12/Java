
package com.mycompany.practiceproblem2;

public class Motorcycle extends Vehicle implements Engine, PassengerVehicle {

    private int seatingCapacity;

    public Motorcycle(String model, int year, int seatingCapacity) {
        super(model, year);
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public void startEngine() {
        System.out.println(model + " engine started with self-start button.");
    }

    @Override
    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    @Override
    public void displayDetails() {
        System.out.println("Motorcycle: " + model + " | Year: " + year +
                " | Seats: " + seatingCapacity);
    }
}
