
package com.mycompany.testemployee3;

import java.util.ArrayList;

public class TestEmployee3 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        Manager m1 = new Manager("Tazminur", 101, 50000, 10000);
        Manager m2 = new Manager("Tanim", 102, 55000, 12000);

        Engineer e1 = new Engineer("Mahid", 201, 40000, 5000);
        Engineer e2 = new Engineer("Mumu", 202, 45000, 6000);

        employees.add(m1);
        employees.add(m2);
        employees.add(e1);
        employees.add(e2);

        for (Employee emp : employees) {
            emp.displayInfo();
        }
    }
}
