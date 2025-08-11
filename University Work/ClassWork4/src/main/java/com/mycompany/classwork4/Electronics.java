
package com.mycompany.classwork4;


public class Electronics extends Product implements Discountable, Warranty {

    private int warrantyMonths;

    public Electronics(String name, double price, int warrantyMonths) {
        super(name, price);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double calculateDiscount() {
        return price * 0.10; 
    }

    @Override
    public int getWarrantyPeriod() {
        return warrantyMonths;
    }

    @Override
    public void displayDetails() {
        System.out.println("Electronics: " + name + " | Price: $" + price +
                " | Warranty: " + warrantyMonths + " months" +
                " | Discount: $" + calculateDiscount());
    }
}
