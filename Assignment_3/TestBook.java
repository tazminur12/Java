package Assignment_3;

import java.util.Scanner;

public class TestBook {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Book[] books = new Book[3];

        for (int i = 0; i < books.length; i++) {
            System.out.println("Enter details for Book " + (i + 1));
            System.out.print("Title: ");
            String title = input.nextLine();

            System.out.print("Author: ");
            String author = input.nextLine();

            System.out.print("Year: ");
            int year = input.nextInt();
            input.nextLine(); 

            books[i] = new Book(title, author, year);
            System.out.println();
        }

        System.out.println("----- Book Details -----");
        for (Book b : books) {
            b.displayBookDetails();
        }

        Book.displayTotalBooks();
    }
}
