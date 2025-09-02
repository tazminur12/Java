
package com.mycompany.taskmanagementsystem;


// Encapsulation: private fields + getters/setters
public class Task {
    private String title;
    private String description;
    private String dueDate; // yyyy-MM-dd
    private String priority; // Low/Medium/High

    public Task(String title, String description, String dueDate, String priority) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getDueDate() { return dueDate; }
    public String getPriority() { return priority; }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }
    public void setPriority(String priority) { this.priority = priority; }

    // Polymorphism: override toString for quick display/logging
    @Override
    public String toString() {
        return title + " | " + dueDate + " | " + priority;
    }
}
