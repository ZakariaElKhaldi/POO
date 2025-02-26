package view;

import javax.swing.*;
import model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.List;

public class MainFrame extends JFrame {
    private StockManager<Produit> stockManager;
    private JTable produitTable;
    private DefaultTableModel tableModel;

    public MainFrame() {
        stockManager = new StockManager<>();

        // Setup frame
        setTitle("Gestion de Stock");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Table setup
        tableModel = new DefaultTableModel(new Object[] { "Nom", "Prix", "Quantité" }, 0);
        produitTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(produitTable);

        // Panel setup
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        // Add buttons
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Ajouter");
        JButton removeButton = new JButton("Supprimer");
        JButton searchButton = new JButton("Rechercher");
        JButton sortButton = new JButton("Trier");

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(sortButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners
        addButton.addActionListener(e -> addProduct());
        removeButton.addActionListener(e -> removeProduct());
        searchButton.addActionListener(e -> searchProduct());
        sortButton.addActionListener(e -> sortProducts());

        add(panel);
        setLocationRelativeTo(null);
    }

    private void addProduct() {
        String name = JOptionPane.showInputDialog(this, "Nom du produit:");
        double price = Double.parseDouble(JOptionPane.showInputDialog(this, "Prix du produit:"));
        int quantity = Integer.parseInt(JOptionPane.showInputDialog(this, "Quantité du produit:"));

        Produit newProduct = new Produit(name, price, quantity);
        stockManager.ajouterProduit(newProduct);
        updateTable(stockManager.getProduits());
    }

    private void removeProduct() {
        int selectedRow = produitTable.getSelectedRow();
        if (selectedRow != -1) {
            Produit selectedProduct = stockManager.getProduits().get(selectedRow);
            stockManager.supprimerProduit(selectedProduct);
            updateTable(stockManager.getProduits());
        }
    }

    private void searchProduct() {
        String name = JOptionPane.showInputDialog(this, "Nom du produit à rechercher:");
        List<Produit> results = stockManager.rechercherProduits(name);
        updateTable(results);
    }

    private void sortProducts() {
        stockManager.trierProduits();
        updateTable(stockManager.getProduits());
    }

    private void updateTable(List<Produit> produits) {
        tableModel.setRowCount(0); // Clear existing rows
        for (Produit p : produits) {
            tableModel.addRow(new Object[] { p.getNom(), p.getPrix(), p.getQuantite() });
        }
    }

    public static void main(String[] args) {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
    }
}
