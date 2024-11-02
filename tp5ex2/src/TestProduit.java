package src;

public class TestProduit {
    public static void main(String[] args) {
        // Test ProduitAlimentaire
        ProduitAlimentaire pomme = new ProduitAlimentaire("Pomme", 50, 0.5f);
        float valeurStockPomme = pomme.calculerValeurStock();
        System.out.println("Valeur du stock pour Pomme: " + valeurStockPomme);
        assert valeurStockPomme == 25.0f : "Erreur: Valeur du stock incorrecte pour Pomme";

        // Test ProduitElectronique
        ProduitElectronique tv = new ProduitElectronique("Télévision", 10, 300.0f);
        float valeurStockTV = tv.calculerValeurStock();
        System.out.println("Valeur du stock pour Télévision: " + valeurStockTV);
        assert valeurStockTV == 3000.0f : "Erreur: Valeur du stock incorrecte pour Télévision";

        System.out.println("Tous les tests ont réussi.");
    }
}

