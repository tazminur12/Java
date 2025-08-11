
package com.mycompany.classwork4;


public class Clothing extends Product implements Discountable, Returnable {

    private int returnDays;

    public Clothing(String name, double price, int returnDays) {
        super(name, price);
        this.returnDays = returnDays;
    }

    @Override
    public double calculateDiscount() {
        return price * 0.20; 
    }

    @Override
    public int getReturnDays() {
        return returnDays;
    }

    @Override
    public void displayDetails() {
        System.out.println("Clothing: " + name + " | Price: $" + price +
                " | Return Period: " + returnDays + " days" +
                " | Discount: $" + calculateDiscount());
    }
}

