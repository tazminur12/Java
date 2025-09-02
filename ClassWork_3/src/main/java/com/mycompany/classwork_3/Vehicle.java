
package com.mycompany.classwork_3;

public class Vehicle {
    protected String brand;
    protected String model;
    protected double price;
    protected String color;

    public Vehicle(String brand, String model, double price, String color) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.color = color;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price + " Taka");
        System.out.println("Color: " + color);
    }
}