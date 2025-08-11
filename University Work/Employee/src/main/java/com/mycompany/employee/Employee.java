

package com.mycompany.employee;


public class Employee {
    private String name;
    private int id;
    private double salary;
    private String designation;

   
    public Employee() {
        this("Unknown", 0, 0.0, "Not Assigned"); 
    }

    
    public Employee(String name, int id) {
        this(name, id, 0.0, "Not Assigned"); 
    }

    public Employee(String name, int id, double salary, String designation) {
        
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.designation = designation;
    }

    public void displayInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("ID: " + this.id);
        System.out.println("Salary: " + this.salary);
        System.out.println("Designation: " + this.designation);
        System.out.println("-----------------------");
    }

    
    public void displayInfo(String message) {
        System.out.println(message);
        displayInfo(); 
    }

    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee("Tanim", 101);
        Employee e3 = new Employee("Tazminur", 102, 50000, "Manager");

        e1.displayInfo("Default Employee Details:");
        e2.displayInfo("Partial Details Provided:");
        e3.displayInfo("Full Employee Details:");
    }
}
