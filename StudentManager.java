
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    double gpa;

    Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", GPA: " + gpa);
    }
}

public class StudentManager {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Student Manager ---");
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number.");
                choice = -1;
                continue;
            }

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> showStudents();
                case 3 -> System.out.println("🚪 Exiting... Goodbye!");
                default -> System.out.println("⚠️ Invalid choice. Try again!");
            }
        } while (choice != 3);
    }

    public static void addStudent() {
        try {
            System.out.print("Enter ID (number): ");
            int id = Integer.parseInt(input.nextLine());

            System.out.print("Enter Name: ");
            String name = input.nextLine();

            System.out.print("Enter GPA (e.g., 3.5): ");
            double gpa = Double.parseDouble(input.nextLine());

            students.add(new Student(id, name, gpa));
            System.out.println("✅ Student added successfully.");
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input. Please enter correct numbers for ID and GPA.");
        }
    }

    public static void showStudents() {
        System.out.println("\n--- Student List ---");
        if (students.isEmpty()) {
            System.out.println("ℹ️ No students found.");
        } else {
            for (Student s : students) {
                s.display();
            }
        }
    }
}
