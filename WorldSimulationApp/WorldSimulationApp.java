// File: WorldSimulationApp.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

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

    public int getId() { return id; }
    public String getName() { return name; }
    public String getHabitat() { return habitat; }
    public String getFood() { return food; }

    public void setName(String name) { this.name = name; }
    public void setHabitat(String habitat) { this.habitat = habitat; }
    public void setFood(String food) { this.food = food; }

    public abstract String describe();
}

class Human extends Being {
    private String region;
    public Human(String name, String region) {
        super(name, "Land", "Various");
        this.region = region;
    }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    @Override
    public String describe() {
        return "ID: " + getId() + ", " + getName() + " (Human from " + region + ")\nHabitat: " + getHabitat() + ", Food: " + getFood();
    }
}

class Animal extends Being {
    public Animal(String name, String habitat, String food) {
        super(name, habitat, food);
    }
    @Override
    public String describe() {
        return "ID: " + getId() + ", " + getName() + " (Animal)\nHabitat: " + getHabitat() + ", Food: " + getFood();
    }
}

class Bird extends Being {
    public Bird(String name, String habitat, String food) {
        super(name, habitat, food);
    }
    @Override
    public String describe() {
        return "ID: " + getId() + ", " + getName() + " (Bird)\nHabitat: " + getHabitat() + ", Food: " + getFood();
    }
}

class WorldManager {
    private ArrayList<Being> beings = new ArrayList<>();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final String filename = "beings.json";

    public void addBeing(Being b) {
        beings.add(b);
    }

    public String listBeings() {
        if (beings.isEmpty()) return "No beings found.";
        StringBuilder sb = new StringBuilder();
        for (Being b : beings) {
            sb.append(b.describe()).append("\n------------------\n");
        }
        return sb.toString();
    }

    public Being findById(int id) {
        for (Being b : beings) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    public boolean deleteById(int id) {
        return beings.removeIf(b -> b.getId() == id);
    }

    public void saveToJson() throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(beings, writer);
        }
    }

    public void loadFromJson() throws IOException {
        try (FileReader reader = new FileReader(filename)) {
            Type listType = new TypeToken<ArrayList<Being>>() {}.getType();
            beings = gson.fromJson(reader, listType);
        }
    }
}

public class WorldSimulationApp {
    private static final WorldManager manager = new WorldManager();
    private static boolean isLoggedIn = false;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WorldSimulationApp::createLoginUI);
    }

    private static void createLoginUI() {
        JFrame frame = new JFrame("Login");
        JTextField userField = new JTextField(15);
        JPasswordField passField = new JPasswordField(15);
        JButton loginBtn = new JButton("Login");

        loginBtn.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());
            if (user.equals("admin") && pass.equals("1234")) {
                isLoggedIn = true;
                frame.dispose();
                createMainUI();
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid credentials");
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(new JLabel("Username:"));
        frame.add(userField);
        frame.add(new JLabel("Password:"));
        frame.add(passField);
        frame.add(loginBtn);
        frame.setSize(250, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void createMainUI() {
        JFrame frame = new JFrame("🌍 World Simulation");
        JTextArea output = new JTextArea(20, 40);
        output.setEditable(false);

        JButton addHuman = new JButton("Add Human");
        JButton addAnimal = new JButton("Add Animal");
        JButton addBird = new JButton("Add Bird");
        JButton showAll = new JButton("Show All");
        JButton delete = new JButton("Delete By ID");
        JButton update = new JButton("Update By ID");
        JButton save = new JButton("Save to JSON");
        JButton load = new JButton("Load from JSON");

        addHuman.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Human Name:");
            String region = JOptionPane.showInputDialog("Region:");
            manager.addBeing(new Human(name, region));
        });

        addAnimal.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Animal Name:");
            String habitat = JOptionPane.showInputDialog("Habitat:");
            String food = JOptionPane.showInputDialog("Food:");
            manager.addBeing(new Animal(name, habitat, food));
        });

        addBird.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Bird Name:");
            String habitat = JOptionPane.showInputDialog("Habitat:");
            String food = JOptionPane.showInputDialog("Food:");
            manager.addBeing(new Bird(name, habitat, food));
        });

        showAll.addActionListener(e -> output.setText(manager.listBeings()));

        delete.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to Delete:"));
            boolean result = manager.deleteById(id);
            output.setText(result ? "Deleted." : "Not found.");
        });

        update.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to Update:"));
            Being b = manager.findById(id);
            if (b != null) {
                String name = JOptionPane.showInputDialog("New Name:", b.getName());
                String habitat = JOptionPane.showInputDialog("New Habitat:", b.getHabitat());
                String food = JOptionPane.showInputDialog("New Food:", b.getFood());
                b.setName(name);
                b.setHabitat(habitat);
                b.setFood(food);
                output.setText("Updated Successfully.");
            } else {
                output.setText("ID not found.");
            }
        });

        save.addActionListener(e -> {
            try {
                manager.saveToJson();
                output.setText("Saved to beings.json");
            } catch (IOException ex) {
                output.setText("Save failed.");
            }
        });

        load.addActionListener(e -> {
            try {
                manager.loadFromJson();
                output.setText("Loaded from beings.json");
            } catch (IOException ex) {
                output.setText("Load failed.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(addHuman);
        panel.add(addAnimal);
        panel.add(addBird);
        panel.add(showAll);
        panel.add(update);
        panel.add(delete);
        panel.add(save);
        panel.add(load);

        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(output), BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
