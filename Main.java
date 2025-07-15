// Main.java

class Person {
    private String name;
    private int age;
    private String qualification;

    public Person(String name, int age, String qualification) {
        this.name = name;
        this.age = age;
        this.qualification = qualification;
    }

    public void showInfo() {
        System.out.println("=== Person Info ===");
        System.out.println("Name         : " + name);
        System.out.println("Age          : " + age);
        System.out.println("Qualification: " + qualification);
    }
}

class Teacher extends Person {
    private String teacherID;
    private String subject;
    private int experience;  
    private String department;

    public Teacher(String name, int age, String qualification,
                   String teacherID, String subject, int experience, String department) {
        super(name, age, qualification); 
        this.teacherID = teacherID;
        this.subject = subject;
        this.experience = experience;
        this.department = department;
    }

    // Method overriding
    @Override
    public void showInfo() {
        System.out.println("=== Teacher Info ===");
        super.showInfo();  
        System.out.println("Teacher ID   : " + teacherID);
        System.out.println("Subject     : " + subject);
        System.out.println("Experience  : " + experience + " years");
        System.out.println("Department  : " + department);
    }
}

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Tazminur Rahman Tanim", 22, "BSc in Computer Science");
        p1.showInfo();

        System.out.println();

        Teacher t1 = new Teacher("Karim Ahmed", 38, "PhD in Computer Science",
                                "T2025", "Programming", 12, "CSE Department");
        t1.showInfo();
    }
}
