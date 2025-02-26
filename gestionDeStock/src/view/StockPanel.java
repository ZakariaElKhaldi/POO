package view;

import model.Produit;
import model.StockManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class StockPanel extends JPanel {
    private JTable table;
    private StockManager<Produit> stockManager;

    public StockPanel(StockManager<Produit> stockManager) {
        this.stockManager = stockManager;
        setLayout(new BorderLayout());

        // Table for displaying products
        table = new JTable();
        updateTable();
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton addButton = new JButton("Ajouter");
        JButton deleteButton = new JButton("Supprimer");
        JButton searchButton = new JButton("Rechercher");
        JButton sortButton = new JButton("Trier");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(sortButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Add product
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nom = JOptionPane.showInputDialog("Nom du produit:");
                double prix = Double.parseDouble(JOptionPane.showInputDialog("Prix du produit:"));
                int quantite = Integer.parseInt(JOptionPane.showInputDialog("Quantité du produit:"));
                Produit produit = new Produit(nom, prix, quantite);
                stockManager.ajouterProduit(produit);
                updateTable();
            }
        });

        // Remove product
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    Produit produit = stockManager.getProduits().get(selectedRow);
                    stockManager.supprimerProduit(produit);
                    updateTable();
                }
            }
        });

        // Search product
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchQuery = JOptionPane.showInputDialog("Nom du produit à rechercher:");
                stockManager.rechercherProduits(searchQuery);
                updateTable();
            }
        });

        // Sort products
        sortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stockManager.trierProduits();
                updateTable();
            }
        });
    }

    // Method to update the table with products from StockManager
    private void updateTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nom");
        model.addColumn("Prix");
        model.addColumn("Quantité");

        for (Produit produit : stockManager.getProduits()) {
            model.addRow(new Object[]{produit.getNom(), produit.getPrix(), produit.getQuantite()});
        }

        table.setModel(model);
    }
}
