
package com.mycompany.classwork_3;


public class Car extends Vehicle {
    private int numberOfSeats;

    public Car(String brand, String model, double price, String color, int numberOfSeats) {
        super(brand, model, price, color);
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Seats: " + numberOfSeats);
        System.out.println("--------------------------------");
    }
}
