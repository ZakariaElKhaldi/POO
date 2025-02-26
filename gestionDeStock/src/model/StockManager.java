package model;

import java.util.*;

public class StockManager<T extends Comparable<T>> {
    private List<T> list = new ArrayList<>();

    public void ajouterProduit(T produit) {
        if (produit != null) {
            list.add(produit);
        }
    }

    public void supprimerProduit(T produit) {
        list.remove(produit);
    }

    public List<T> getProduits() {
        return new ArrayList<>(list); // Pour éviter les modifications externes
    }

    public Iterator<T> iterator() {
        return list.iterator();
    }

    public List<T> rechercherProduits(String nom) {
        List<T> res = new ArrayList<>();
        for (T p : list) {
            if (p instanceof Produit && ((Produit) p).getNom().equalsIgnoreCase(nom)) {
                res.add(p);
            }
        }
        return res;
    }

    public void trierProduits() {
        Collections.sort(list);
    }

    public T getProduitLePlusCher() {
        return Collections.max(list, Comparator.comparingDouble(p -> ((Produit) p).getPrix()));
    }

    public void afficherProduits() {
        for (T p : list) {
            System.out.println(p.toString());
        }
    }

    public static void main(String[] args) {
        StockManager<Produit> manager = new StockManager<>();

        Produit p1 = new Produit("Téléphone", 5000, 10);
        Produit p2 = new Produit("Ordinateur", 12000, 5);
        Produit p3 = new Produit("Clavier", 250, 20);

        manager.ajouterProduit(p1);
        manager.ajouterProduit(p2);
        manager.ajouterProduit(p3);

        System.out.println("Liste des produits après ajout:");
        manager.afficherProduits();

        System.out.println("\nRecherche de 'Téléphone':");
        System.out.println(manager.rechercherProduits("Téléphone"));

        System.out.println("\nAprès tri par nom:");
        manager.trierProduits();
        manager.afficherProduits();

        System.out.println("\nProduit le plus cher:");
        System.out.println(manager.getProduitLePlusCher());
    }
}
