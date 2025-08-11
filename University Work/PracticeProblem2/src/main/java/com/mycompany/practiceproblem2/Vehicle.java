
package com.mycompany.practiceproblem2;

public abstract class Vehicle {
    protected String model;
    protected int year;

    public Vehicle(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public String getModel() { return model; }
    public int getYear() { return year; }

    public abstract void displayDetails();
}
