

package com.mycompany.classwork4;


public class ClassWork4 {

    public static void main(String[] args) {

        Product p1 = new Electronics("Laptop", 80000, 24);
        Product p2 = new Clothing("T-Shirt", 1200, 15);
        Product p3 = new Book("Java Programming", 1500, "Herbert Schildt");

        p1.displayDetails();
        p2.displayDetails();
        p3.displayDetails();
    }
}