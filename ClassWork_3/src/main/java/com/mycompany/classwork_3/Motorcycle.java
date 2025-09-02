
package com.mycompany.classwork_3;

public class Motorcycle extends Vehicle {
    private String engineCC;

    public Motorcycle(String brand, String model, double price, String color, String engineCC) {
        super(brand, model, price, color);
        this.engineCC = engineCC;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Engine Capacity: " + engineCC);
        System.out.println("--------------------------------");
    }
}
