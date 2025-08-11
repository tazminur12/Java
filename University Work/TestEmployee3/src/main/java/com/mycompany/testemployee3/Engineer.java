
package com.mycompany.testemployee3;


public class Engineer extends Employee {
    private double projectAllowance;

    public Engineer(String name, int id, double salary, double projectAllowance) {
        super(name, id, salary);
        this.projectAllowance = projectAllowance;
    }

    public double calculateTotalSalary() {
        return salary + projectAllowance;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Project Allowance: " + projectAllowance);
        System.out.println("Total Salary: " + calculateTotalSalary());
        System.out.println("---------------------------");
    }
}
