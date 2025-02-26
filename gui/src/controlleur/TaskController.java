package controlleur;

import model.Task;
import model.TaskManager;
import vue.TaskView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TaskController {
    private TaskView view;
    private TaskManager taskManager;

    public TaskController(TaskView view) {
        this.view = view;
        this.taskManager = new TaskManager();
        loadTasksIntoView();
    }

    public void addTask(String description) {
        if (description == null || description.trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "La description ne peut pas être vide.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Task task = new Task(description);
        taskManager.addTask(task);
        updateTable();
    }

    public void removeTask(int index) {
        if (index >= 0) {
            int confirmation = JOptionPane.showConfirmDialog(view, "Voulez-vous vraiment supprimer cette tâche ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                taskManager.removeTask(index);
                updateTable();
            }
        } else {
            JOptionPane.showMessageDialog(view, "Sélectionnez une tâche à supprimer.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void toggleTaskCompletion(int index) {
        if (index >= 0) {
            taskManager.toggleTaskCompletion(index);
            updateTable();
        } else {
            JOptionPane.showMessageDialog(view, "Sélectionnez une tâche.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTable() {
        DefaultTableModel tableModel = view.getTableModel();
        tableModel.setRowCount(0);
        for (Task task : taskManager.getTasks()) {
            tableModel.addRow(new Object[]{task.getDescription(), task.isCompleted()});
        }
    }

    private void loadTasksIntoView() {
        updateTable();
    }
}
