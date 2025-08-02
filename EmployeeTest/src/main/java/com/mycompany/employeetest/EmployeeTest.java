package com.mycompany.employeetest;


public class EmployeeTest {
    public static void main(String[] args) {
       
        Employee emp1 = new Employee("Tanim", 28, "Software Engineer", 75000);
        Employee emp2 = new Employee("Sakib", 35, "Project Manager", 95000);
        Employee emp3 = new Employee("Sadik", 30, "QA Analyst", 65000);

        
        emp1.displayEmployeeDetails();
        emp2.displayEmployeeDetails();
        emp3.displayEmployeeDetails();

        Employee.displayTotalEmployees();
    }
}

