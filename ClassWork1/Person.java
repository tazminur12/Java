package ClassWork1;

public class Person {
    private String name;
    private int age;
    private String gender;
    private String address;

    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.gender = "Unknown";
        this.address = "Unknown";
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.gender = "Unknown";
        this.address = "Unknown";
    }

    public Person(String name, int age, String gender, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public void displayInfo() {
        System.out.println("Name    : " + this.name);
        System.out.println("Age     : " + this.age);
        System.out.println("Gender  : " + this.gender);
        System.out.println("Address : " + this.address);
    }

    public void updateInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void updateInfo(String name, int age, String gender, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public static void main(String[] args) {
        Person p1 = new Person(); 
        Person p2 = new Person("Sakib", 25); 
        Person p3 = new Person("Omar", 30, "Male", "Mohammadpur"); 

        System.out.println("Person 1:");
        p1.displayInfo();

        System.out.println("\nPerson 2:");
        p2.displayInfo();

        System.out.println("\nPerson 3:");
        p3.displayInfo();

        p1.updateInfo("Tanim", 20, "Male", "Dhaka");
        System.out.println("\nPerson 1 After Update:");
        p1.displayInfo();
    }
}
