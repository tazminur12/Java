/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practiceproblem2;

/**
 *
 * @author m2air
 */
public class PracticeProblem2 {

    public static void main(String[] args) {
        Vehicle v1 = new Car("Toyota Corolla", 2022, 5);
        Vehicle v2 = new Motorcycle("Yamaha R15", 2023, 2);
        Vehicle v3 = new Truck("Tata Cargo", 2020, 12);

        v1.displayDetails();
        ((Engine) v1).startEngine();

        v2.displayDetails();
        ((Engine) v2).startEngine();

        v3.displayDetails();
        ((Engine) v3).startEngine();
    }
}
