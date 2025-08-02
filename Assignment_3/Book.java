package Assignment_3;

import java.util.Scanner;

public class Book {
    private String title;
    private String author;
    private int year;

    private static String genre;
    private static int bookCount = 0;

    static {
        genre = "Fiction";  
    }

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        bookCount++; 
    }

    public void displayBookDetails() {
        System.out.println("Title:  " + title);
        System.out.println("Author: " + author);
        System.out.println("Year:   " + year);
        System.out.println("Genre:  " + genre);
        System.out.println("-------------------------");
    }
    
    public static void displayTotalBooks() {
        System.out.println("Total number of books: " + bookCount);
    }
}
