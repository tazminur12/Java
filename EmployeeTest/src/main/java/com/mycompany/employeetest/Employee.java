package com.mycompany.employeetest;

public class Employee {
    
    String name;
    int age;
    String designation;
    double salary;

   
    static String companyName = "Tech Innovators Ltd.";
    static String companyAddress = "123 Software Park, Dhaka";
    static int employeeCount = 0;


    public Employee(String name, int age, String designation, double salary) {
        this.name = name;
        this.age = age;
        this.designation = designation;
        this.salary = salary;
        employeeCount++; 
    }

    public void displayEmployeeDetails() {
        System.out.println("----- Employee Details -----");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Designation: " + designation);
        System.out.println("Salary: $" + salary);
        System.out.println("Company: " + companyName);
        System.out.println("Address: " + companyAddress);
        System.out.println("-----------------------------\n");
    }

    public static void displayTotalEmployees() {
        System.out.println("Total number of employees: " + employeeCount);
    }
}
