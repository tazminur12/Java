package com.mycompany.taskmanagementsystem;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

// Concrete implementation + File Handling (CSV)
public class TaskManager implements TaskOperations {
    private final List<Task> tasks = new ArrayList<>();
    private final Path file = Paths.get("tasks.csv");

    @Override
    public void addTask(Task task) {
        tasks.add(task);
        try { save(); } catch (Exception ignored) {}
    }

    @Override
    public void updateTask(int index, Task task) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, task);
            try { save(); } catch (Exception ignored) {}
        }
    }

    @Override
    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            try { save(); } catch (Exception ignored) {}
        }
    }

    @Override
    public List<Task> getAllTasks() {
        return tasks;
    }

    @Override
    public void save() throws Exception {
        // CSV Header + rows; quote fields safely
        try (BufferedWriter bw = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
            bw.write("title,description,dueDate,priority\n");
            for (Task t : tasks) {
                bw.write(csv(t.getTitle())); bw.write(",");
                bw.write(csv(t.getDescription())); bw.write(",");
                bw.write(csv(t.getDueDate())); bw.write(",");
                bw.write(csv(t.getPriority()));
                bw.write("\n");
            }
        }
    }

    @Override
    public void load() throws Exception {
        tasks.clear();
        if (!Files.exists(file)) return;
        try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            String line;
            boolean headerSkipped = false;
            while ((line = br.readLine()) != null) {
                if (!headerSkipped) { headerSkipped = true; continue; }
                List<String> cols = parseCsvLine(line);
                if (cols.size() >= 4) {
                    String title = cols.get(0);
                    String desc  = cols.get(1);
                    String date  = cols.get(2);
                    String prio  = cols.get(3);
                    tasks.add(new Task(title, desc, date, prio));
                }
            }
        }
    }

    // --- CSV helpers ---
    private String csv(String s) {
        if (s == null) s = "";
        String q = s.replace("\"", "\"\"");
        return "\"" + q + "\"";
    }

    private List<String> parseCsvLine(String line) {
        List<String> out = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        boolean inQ = false;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (inQ) {
                if (c == '"') {
                    if (i + 1 < line.length() && line.charAt(i + 1) == '"') {
                        cur.append('"'); i++;
                    } else {
                        inQ = false;
                    }
                } else cur.append(c);
            } else {
                if (c == '"') inQ = true;
                else if (c == ',') { out.add(cur.toString()); cur.setLength(0); }
                else cur.append(c);
            }
        }
        out.add(cur.toString());
        return out;
    }
}
