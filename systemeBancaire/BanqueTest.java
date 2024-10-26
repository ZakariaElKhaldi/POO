package systemeBancaire;

public class BanqueTest {
    public static void main(String[] args) {
        // Création de la banque
        Banque banque = new Banque();

        // Création et ajout de comptes bancaires
        CompteBancaire compte1 = new CompteBancaire("001", "Alice");
        CompteBancaire compte2 = new CompteBancaire("002", "Bob");
        CompteBancaire compte3 = new CompteBancaire("003", "Charlie");

        banque.ajouterCompte(compte1);
        banque.ajouterCompte(compte2);
        banque.ajouterCompte(compte3);

        // Effectuer des transactions
        compte1.deposer(500);
        compte2.deposer(300);
        compte1.retirer(200);
        banque.transfert("001", "003", 100);

        // Afficher l'historique des transactions pour chaque compte
        compte1.afficherHistoriqueTransactions();
        compte2.afficherHistoriqueTransactions();
        compte3.afficherHistoriqueTransactions();

        // Affichage du nombre total de comptes
        Banque.afficherNombreComptes();
    }
}


