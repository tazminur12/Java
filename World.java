import java.util.*;
import java.io.*;

// Abstract base class
abstract class Being {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String habitat;
    private String food;

    public Being(String name, String habitat, String food) {
        this.id = idCounter++;
        this.name = name;
        this.habitat = habitat;
        this.food = food;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getFood() {
        return food;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public void setFood(String food) {
        this.food = food;
    }

    // Abstract method to describe the being
    public abstract void describe();
}

// ---------------- HUMAN ----------------
class Human extends Being {
    private String region;

    public Human(String name, String region) {
        super(name, "Land", "Various");
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public void describe() {
        System.out.println("ID: " + getId() + " | " + getName() + " is a human from " + region + ".");
        System.out.println("Habitat: " + getHabitat() + ", Food: " + getFood());
    }
}

// ---------------- ANIMAL ----------------
class Animal extends Being {
    public Animal(String name, String habitat, String food) {
        super(name, habitat, food);
    }

    @Override
    public void describe() {
        System.out.println("ID: " + getId() + " | " + getName() + " is an animal.");
        System.out.println("Habitat: " + getHabitat() + ", Food: " + getFood());
    }
}

// ---------------- BIRD ----------------
class Bird extends Being {
    public Bird(String name, String habitat, String food) {
        super(name, habitat, food);
    }

    @Override
    public void describe() {
        System.out.println("ID: " + getId() + " | " + getName() + " is a bird.");
        System.out.println("Habitat: " + getHabitat() + ", Food: " + getFood());
    }
}

// ---------------- MAIN CLASS ----------------
public class World {
    static ArrayList<Being> beings = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n--- 🌍 World Menu ---");
            System.out.println("1. Add Human");
            System.out.println("2. Add Animal");
            System.out.println("3. Add Bird");
            System.out.println("4. Show All Beings");
            System.out.println("5. Save to File");
            System.out.println("6. Exit");
            System.out.println("7. Search by ID");
            System.out.println("8. Delete by ID");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> addHuman();
                case 2 -> addAnimal();
                case 3 -> addBird();
                case 4 -> showBeings();
                case 5 -> saveToFile();
                case 6 -> {
                    running = false;
                    System.out.println("Exiting World...");
                }
                case 7 -> searchById();
                case 8 -> deleteById();
                default -> System.out.println("Invalid option.");
            }
        }
    }

    // Add Human
    private static void addHuman() {
        System.out.print("Enter human name: ");
        String name = scanner.nextLine();
        System.out.print("Enter region (e.g. Africa, Asia): ");
        String region = scanner.nextLine();

        Human human = new Human(name, region);
        beings.add(human);
        System.out.println("✅ Human added successfully.");
    }

    // Add Animal
    private static void addAnimal() {
        System.out.print("Enter animal name: ");
        String name = scanner.nextLine();
        System.out.print("Enter habitat (e.g. Forest, Water): ");
        String habitat = scanner.nextLine();
        System.out.print("Enter food type: ");
        String food = scanner.nextLine();

        Animal animal = new Animal(name, habitat, food);
        beings.add(animal);
        System.out.println("✅ Animal added successfully.");
    }

    // Add Bird
    private static void addBird() {
        System.out.print("Enter bird name: ");
        String name = scanner.nextLine();
        System.out.print("Enter habitat (e.g. Tree, Mountain): ");
        String habitat = scanner.nextLine();
        System.out.print("Enter food type: ");
        String food = scanner.nextLine();

        Bird bird = new Bird(name, habitat, food);
        beings.add(bird);
        System.out.println("✅ Bird added successfully.");
    }

    // Show all beings
    private static void showBeings() {
        System.out.println("\n--- All Beings in the World ---");
        if (beings.isEmpty()) {
            System.out.println("No beings found.");
        } else {
            for (Being b : beings) {
                b.describe();
                System.out.println("-------------------------");
            }
        }
    }

    // Save to file
    private static void saveToFile() {
        try (PrintWriter writer = new PrintWriter("beings.txt")) {
            for (Being b : beings) {
                writer.println("ID: " + b.getId());
                writer.println("Name: " + b.getName());
                writer.println("Habitat: " + b.getHabitat());
                writer.println("Food: " + b.getFood());
                writer.println("----------------------------");
            }
            System.out.println("✅ Data saved to beings.txt");
        } catch (IOException e) {
            System.out.println("❌ Error saving to file: " + e.getMessage());
        }
    }

    // Search by ID
    private static void searchById() {
        System.out.print("Enter ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Being b : beings) {
            if (b.getId() == id) {
                System.out.println("✅ Being Found:");
                b.describe();
                return;
            }
        }
        System.out.println("❌ No being found with ID " + id);
    }

    // Delete by ID
    private static void deleteById() {
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Iterator<Being> iterator = beings.iterator();
        while (iterator.hasNext()) {
            Being b = iterator.next();
            if (b.getId() == id) {
                iterator.remove();
                System.out.println("🗑️ Being with ID " + id + " deleted.");
                return;
            }
        }

        System.out.println("❌ No being found with ID " + id);
    }
}
