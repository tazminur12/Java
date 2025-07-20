package ClassWork1;

public class Employee {
    // Instance variables
    private String name;
    private int id;
    private double salary;
    private String designation;

    // Default constructor
    public Employee() {
        this.name = "Unknown";
        this.id = 0;
        this.salary = 0.0;
        this.designation = "Not Assigned";
    }

    // Constructor with name and ID only
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
        this.salary = 0.0;
        this.designation = "Not Assigned";
    }

    // Constructor with all properties
    public Employee(String name, int id, double salary, String designation) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.designation = designation;
    }

    // Method to display employee info
    public void displayInfo() {
        System.out.println("Name        : " + this.name);
        System.out.println("ID          : " + this.id);
        System.out.println("Salary      : $" + this.salary);
        System.out.println("Designation : " + this.designation);
    }

    // Method Overloading: update name and designation
    public void updateInfo(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    // Method Overloading: update name, salary and designation
    public void updateInfo(String name, double salary, String designation) {
        this.name = name;
        this.salary = salary;
        this.designation = designation;
    }

    // Main method to test everything
    public static void main(String[] args) {
        // Using default constructor
        Employee emp1 = new Employee();
        System.out.println("Employee 1 (Default):");
        emp1.displayInfo();

        // Using constructor with 2 arguments
        Employee emp2 = new Employee("Tanim", 102);
        System.out.println("\nEmployee 2 (Name & ID):");
        emp2.displayInfo();

        // Using constructor with all arguments
        Employee emp3 = new Employee("Sakib", 103, 50000.0, "Software Engineer");
        System.out.println("\nEmployee 3 (Full Details):");
        emp3.displayInfo();

        // Update emp1 details using method overloading
        emp1.updateInfo("Jabir", 45000.0, "Manager");
        System.out.println("\nEmployee 1 After Update:");
        emp1.displayInfo();
    }
}
