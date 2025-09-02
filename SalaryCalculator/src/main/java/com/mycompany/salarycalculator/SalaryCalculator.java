/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.salarycalculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A custom exception class to represent the error of a negative number where a positive one is expected,
 * such as a salary.
 */
class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

/**
 * This program reads employee data from a file, calculates the average salary for each employee,
 * and writes the results to another file. It includes robust error handling for various exceptions.
 *
 * The expected format for the input file (e.g., "employees.txt") is one employee per line:
 * Name,Salary1,Salary2,Salary3
 *
 * Example:
 * John Doe,50000,52000,54000
 * Jane Smith,60000,61000,65000
 */
public class SalaryCalculator {

    public static void main(String[] args) {
        // Define the input and output file paths
        String inputFile = "employees.txt";
        String outputFile = "average_salaries.txt";

        // Use try-with-resources to ensure BufferedReader and BufferedWriter are closed automatically
        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            // Read the input file line by line
            while ((line = reader.readLine()) != null) {
                // Split the line by comma to get the name and salaries
                String[] parts = line.split(",");

                // Basic validation for the number of parts
                if (parts.length != 4) {
                    System.err.println("Skipping malformed line: " + line);
                    continue; // Skip to the next line
                }

                try {
                    String name = parts[0].trim();
                    // Parse salary strings into doubles
                    double salary1 = Double.parseDouble(parts[1].trim());
                    double salary2 = Double.parseDouble(parts[2].trim());
                    double salary3 = Double.parseDouble(parts[3].trim());

                    // Check for negative salary values
                    if (salary1 < 0 || salary2 < 0 || salary3 < 0) {
                        throw new NegativeNumberException("Salary cannot be negative. Found in line: " + line);
                    }

                    // Calculate the average salary
                    double averageSalary = (salary1 + salary2 + salary3) / 3.0;

                    // Write the name and the formatted average salary to the output file
                    writer.write(name + ", Average Salary: " + String.format("%.2f", averageSalary));
                    writer.newLine(); // Move to the next line in the output file

                } catch (NumberFormatException e) {
                    // Handle cases where a salary is not a valid number
                    System.err.println("Error parsing number for line: " + line + ". Skipping.");
                    // Log the specific error for debugging
                    System.err.println("Details: " + e.getMessage());
                } catch (NegativeNumberException e) {
                    // Handle cases where a salary is a negative number
                    System.err.println("Error: " + e.getMessage() + " Skipping this record.");
                }
            }
            System.out.println("Successfully calculated average salaries and wrote them to " + outputFile);

        } catch (FileNotFoundException e) {
            // Handle the case where the input file does not exist
            System.err.println("Error: The input file '" + inputFile + "' was not found.");
        } catch (IOException e) {
            // Handle other general I/O errors (e.g., permission issues)
            System.err.println("An I/O error occurred: " + e.getMessage());
        } catch (Exception e) {
            // A catch-all for any other unexpected exceptions
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
