
package com.mycompany.classwork4;

public class Book extends Product implements Discountable, AuthorDetails {

    private String author;

    public Book(String name, double price, String author) {
        super(name, price);
        this.author = author;
    }

    @Override
    public double calculateDiscount() {
        return price * 0.05; 
    }

    @Override
    public String getAuthorName() {
        return author;
    }

    @Override
    public void displayDetails() {
        System.out.println("Book: " + name + " | Author: " + author +
                " | Price: $" + price +
                " | Discount: $" + calculateDiscount());
    }
}
