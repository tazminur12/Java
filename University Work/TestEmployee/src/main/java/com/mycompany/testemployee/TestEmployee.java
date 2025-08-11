
package com.mycompany.testemployee;


public class TestEmployee {
    public static void main(String[] args) {
   
        Employee emp1 = new Employee("Tazminur", 101, 55000.50, "Software Engineer");
        Employee emp2 = new Employee("Tanim", 102, 65000.75, "Project Manager");

     
        emp1.displayInfo();
        emp2.displayInfo();

        emp1.setSalary(58000.00);
        emp1.setDesignation("Senior Software Engineer");

        System.out.println("After Update:");
        emp1.displayInfo();
    }
}
