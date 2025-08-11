
package com.mycompany.practiceproblem2;


public class Car extends Vehicle implements Engine, PassengerVehicle {

    private int seatingCapacity;

    public Car(String model, int year, int seatingCapacity) {
        super(model, year);
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public void startEngine() {
        System.out.println(model + " engine started with key ignition.");
    }

    @Override
    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    @Override
    public void displayDetails() {
        System.out.println("Car: " + model + " | Year: " + year +
                " | Seats: " + seatingCapacity);
    }
}

