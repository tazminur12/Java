
package com.mycompany.taskmanagementsystem;

import java.util.List;

// Abstraction: interface defines behaviour
public interface TaskOperations {
    void addTask(Task task);
    void updateTask(int index, Task task);
    void deleteTask(int index);
    List<Task> getAllTasks();
    void save() throws Exception;
    void load() throws Exception;
}
