

package com.mycompany.registrationform3;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class RegistrationForm3 extends JFrame {
    private JTextField nameField, emailField, usernameField, phoneField;
    private JPasswordField passwordField, confirmPasswordField;
    private JTextArea addressArea;
    private JButton registerButton, uploadButton;
    private JLabel fileLabel;
    private File profilePicture;

    public RegistrationForm3() {
        setTitle("Registration Form");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 2, 10, 10));

       
        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

       
        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

       
        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Phone:"));
        phoneField = new JTextField();
        add(phoneField);

        add(new JLabel("Address:"));
        addressArea = new JTextArea(3, 20);
        add(new JScrollPane(addressArea));

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        add(new JLabel("Confirm Password:"));
        confirmPasswordField = new JPasswordField();
        add(confirmPasswordField);

        add(new JLabel("Profile Picture:"));
        JPanel filePanel = new JPanel(new BorderLayout());
        fileLabel = new JLabel("No file selected");
        uploadButton = new JButton("Choose File");
        filePanel.add(fileLabel, BorderLayout.CENTER);
        filePanel.add(uploadButton, BorderLayout.EAST);
        add(filePanel);

        registerButton = new JButton("Register");
        add(registerButton);

        add(new JLabel(""));

        uploadButton.addActionListener(e -> chooseFile());
        registerButton.addActionListener(e -> validateForm());

        setVisible(true);
    }

    private void chooseFile() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            profilePicture = fileChooser.getSelectedFile();
            fileLabel.setText(profilePicture.getName());
        }
    }

    private void validateForm() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String username = usernameField.getText().trim();
        String phone = phoneField.getText().trim();
        String address = addressArea.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
        String confirmPassword = new String(confirmPasswordField.getPassword()).trim();

        if (name.isEmpty() || email.isEmpty() || username.isEmpty() ||
            phone.isEmpty() || address.isEmpty() ||
            password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(this, "Invalid email address!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!phone.matches("\\d{10,15}")) {
            JOptionPane.showMessageDialog(this, "Phone must be 10–15 digits!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (profilePicture == null) {
            JOptionPane.showMessageDialog(this, "Please select a profile picture!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        saveUserData(name, email, username, phone, address, password, profilePicture);

        JOptionPane.showMessageDialog(this, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void saveUserData(String name, String email, String username, String phone,
                              String address, String password, File profilePic) {
        try (FileWriter writer = new FileWriter("users.txt", true)) {
            writer.write("Name: " + name + "\n");
            writer.write("Email: " + email + "\n");
            writer.write("Username: " + username + "\n");
            writer.write("Phone: " + phone + "\n");
            writer.write("Address: " + address + "\n");
            writer.write("Password: " + password + "\n");
            writer.write("Profile Picture: " + profilePic.getAbsolutePath() + "\n");
            writer.write("--------------------------\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving data!", "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new RegistrationForm3();
    }
}
