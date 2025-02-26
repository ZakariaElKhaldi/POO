package vue;

import controlleur.TaskController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskView extends JFrame {
    private JTextField taskInput;
    private JButton addButton, removeButton;
    private JCheckBox completeCheckBox;
    private JTable taskTable;
    private DefaultTableModel tableModel;
    private TaskController controller;

    public TaskView() {

        setTitle("Gestionnaire de Tâches");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel jp = new JPanel();
        jp.setLayout(new FlowLayout());

        taskInput = new JTextField(20);
        addButton = new JButton("Ajouter");
        removeButton = new JButton("Supprimer");
        completeCheckBox = new JCheckBox("Complété");

        jp.add(taskInput);
        jp.add(addButton);
        jp.add(removeButton);
        jp.add(completeCheckBox);
        add(jp, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"Description", "Completed"}, 0);
        taskTable = new JTable(tableModel);

        add(new JScrollPane(taskTable), BorderLayout.CENTER);

        controller = new TaskController(this);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taskDescription = taskInput.getText();
                controller.addTask(taskDescription);
                taskInput.setText("");
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = taskTable.getSelectedRow();
                controller.removeTask(selectedRow);
            }
        });

        completeCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = taskTable.getSelectedRow();
                controller.toggleTaskCompletion(selectedRow);
            }
        });

        setVisible(true);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public static void main(String[] args) {
    	new TaskView();
    }
}
