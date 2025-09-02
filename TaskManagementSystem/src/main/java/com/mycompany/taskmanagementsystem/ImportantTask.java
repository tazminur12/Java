
package com.mycompany.taskmanagementsystem;


// Inheritance: ImportantTask extends Task
public class ImportantTask extends Task {
    private String note; // extra field to show extension

    public ImportantTask(String title, String description, String dueDate, String priority, String note) {
        super(title, description, dueDate, priority);
        this.note = note;
    }

    public String getNote() { return note; }

    // Polymorphism: different toString
    @Override
    public String toString() {
        return "[IMPORTANT] " + super.toString() + " | Note: " + note;
    }
}
