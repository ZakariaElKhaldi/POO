package systemeBancaire;
import java.util.ArrayList;
import java.util.List;

public class CompteBancaire {
    private String numeroCompte;
    private double solde;
    private String titulaire;
    private List<Transaction> historiqueTransactions;

    public CompteBancaire(String numeroCompte, String titulaire) {
        this.numeroCompte = numeroCompte;
        this.titulaire = titulaire;
        this.solde = 0;
        this.historiqueTransactions = new ArrayList<>();
    }

    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            historiqueTransactions.add(new Transaction("credit", montant));
            System.out.println(montant + " déposé. Nouveau solde : " + solde);
        }
    }

    public void retirer(double montant) {
        if (montant > 0 && solde >= montant) {
            solde -= montant;
            historiqueTransactions.add(new Transaction("debit", montant));
            System.out.println(montant + " retiré. Nouveau solde : " + solde);
        } else {
            System.out.println("Retrait refusé : solde insuffisant.");
        }
    }

    public void afficherSolde() {
        System.out.println("Solde du compte " + numeroCompte + " : " + solde);
    }


    public void afficherHistoriqueTransactions() {
        System.out.println("Historique des transactions pour le compte " + numeroCompte + " :");
        for (Transaction transaction : historiqueTransactions) {
            System.out.println(transaction);
        }
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setTitulaire(String titulaire) {
        this.titulaire = titulaire;
    }
}
