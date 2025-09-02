
package com.mycompany.taskmanagementsystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TaskManagementSystem extends JFrame {

    private final TaskManager manager = new TaskManager();
    private final DefaultTableModel model =
            new DefaultTableModel(new String[]{"Title","Description","Due Date","Priority"}, 0) {
                @Override public boolean isCellEditable(int r, int c) { return false; }
            };

    private JTable table;
    private JTextField tfTitle, tfDue;
    private JTextArea taDesc;
    private JComboBox<String> cbPriority;

    public TaskManagementSystem() {
        setTitle("Task Management System - GUI (OOP + File I/O)");
        setSize(900, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));

        // ---- Top form panel ----
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(6,6,6,6);
        gc.fill = GridBagConstraints.HORIZONTAL;

        tfTitle = new JTextField();
        tfDue   = new JTextField(); // format hint: yyyy-MM-dd
        taDesc  = new JTextArea(4, 20);
        taDesc.setLineWrap(true);
        taDesc.setWrapStyleWord(true);
        cbPriority = new JComboBox<>(new String[]{"Low","Medium","High"});

        int r=0;
        gc.gridy = r; gc.gridx=0; form.add(new JLabel("Title:"), gc);
        gc.gridx=1; form.add(tfTitle, gc);

        r++; gc.gridy = r; gc.gridx=0; form.add(new JLabel("Due Date (yyyy-MM-dd):"), gc);
        gc.gridx=1; form.add(tfDue, gc);

        r++; gc.gridy = r; gc.gridx=0; form.add(new JLabel("Priority:"), gc);
        gc.gridx=1; form.add(cbPriority, gc);

        r++; gc.gridy = r; gc.gridx=0; gc.anchor = GridBagConstraints.NORTHWEST;
        form.add(new JLabel("Description:"), gc);
        gc.gridx=1; gc.weightx=1; gc.weighty=1; gc.fill = GridBagConstraints.BOTH;
        form.add(new JScrollPane(taDesc), gc);

        add(form, BorderLayout.NORTH);

        // ---- Table center ----
        table = new JTable(model);
        table.setRowHeight(22);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // ---- Buttons bottom ----
        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 8));
        JButton btnAdd = new JButton("Add");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");
        JButton btnClear = new JButton("Clear");
        JButton btnReload = new JButton("Reload from File");

        actions.add(btnAdd);
        actions.add(btnUpdate);
        actions.add(btnDelete);
        actions.add(btnClear);
        actions.add(btnReload);
        add(actions, BorderLayout.SOUTH);

        // ---- Events ----
        btnAdd.addActionListener(e -> {
            Task t = readFormAsTask();
            if (t == null) return;
            manager.addTask(t);
            refreshTable();
            clearForm();
        });

        btnUpdate.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row < 0) { msg("Select a row to update."); return; }
            Task t = readFormAsTask();
            if (t == null) return;
            manager.updateTask(row, t);
            refreshTable();
        });

        btnDelete.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row < 0) { msg("Select a row to delete."); return; }
            int c = JOptionPane.showConfirmDialog(this, "Delete selected task?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (c == JOptionPane.YES_OPTION) {
                manager.deleteTask(row);
                refreshTable();
                clearForm();
            }
        });

        btnClear.addActionListener(e -> clearForm());

        btnReload.addActionListener(e -> {
            try {
                manager.load();
                refreshTable();
                msg("Reloaded from file.");
            } catch (Exception ex) {
                msg("Failed to load: " + ex.getMessage());
            }
        });

        // Table selection -> fill form
        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                tfTitle.setText(val(row,0));
                taDesc.setText(val(row,1));
                tfDue.setText(val(row,2));
                cbPriority.setSelectedItem(val(row,3));
            }
        });

        // Initial load
        try { manager.load(); } catch (Exception ignored) {}
        refreshTable();
    }

    private Task readFormAsTask() {
        String title = tfTitle.getText().trim();
        String due   = tfDue.getText().trim();
        String desc  = taDesc.getText().trim();
        String prio  = (String) cbPriority.getSelectedItem();

        if (title.isEmpty()) { msg("Title is required."); return null; }
        if (due.isEmpty())   { msg("Due date is required (yyyy-MM-dd)."); return null; }
        if (prio == null) prio = "Low";

        // Example: if title starts with "!" create ImportantTask (shows inheritance/polymorphism in action)
        if (title.startsWith("!")) {
            return new ImportantTask(title, desc, due, prio, "Flagged by user with '!'");
        }
        return new Task(title, desc, due, prio);
    }

    private void refreshTable() {
        model.setRowCount(0);
        List<Task> list = manager.getAllTasks();
        for (Task t : list) {
            model.addRow(new Object[]{ t.getTitle(), t.getDescription(), t.getDueDate(), t.getPriority() });
        }
    }

    private void clearForm() {
        tfTitle.setText("");
        tfDue.setText("");
        taDesc.setText("");
        cbPriority.setSelectedIndex(0);
        table.clearSelection();
    }

    private String val(int row, int col) {
        Object v = model.getValueAt(row, col);
        return v == null ? "" : v.toString();
    }

    private void msg(String s) {
        JOptionPane.showMessageDialog(this, s);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TaskManagementSystem().setVisible(true));
    }
}
