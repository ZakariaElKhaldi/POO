package ex3;

public class Compte {
    private double solde;

    public Compte(double soldeInitial) {
        this.solde = soldeInitial;
    }

    public double getSolde() {
        return solde;
    }

    public void retirer(double montant) throws SoldeInsuffisantException {
        if (montant > solde) {
            throw new SoldeInsuffisantException("Erreur : Solde insuffisant !");
        }
        solde -= montant;
        System.out.println("Retrait effectué avec succès. Nouveau solde : " + solde);
    }

    public void deposer(double montant) {
        solde += montant;
        System.out.println("Dépôt effectué avec succès. Nouveau solde : " + solde);
    }
}

