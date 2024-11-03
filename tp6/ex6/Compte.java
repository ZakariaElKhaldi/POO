package ex6;

public class Compte {
    private double solde;

    public Compte(double soldeInitial) {
        this.solde = soldeInitial;
    }

    public double getSolde() {
        return solde;
    }

    public void verser(double montant) throws MontantNegatifException {
        if (montant < 0) {
            throw new MontantNegatifException("Erreur : Le montant à déposer ne peut pas être négatif.");
        }
        solde += montant;
        System.out.println("Dépôt effectué avec succès. Nouveau solde : " + solde);
    }

    public void retirer(double montant) throws MontantNegatifException, SoldeInsuffisantException {
        if (montant < 0) {
            throw new MontantNegatifException("Erreur : Le montant à retirer ne peut pas être négatif.");
        }
        if (montant > solde) {
            throw new SoldeInsuffisantException("Erreur : Solde insuffisant !");
        }
        solde -= montant;
        System.out.println("Retrait effectué avec succès. Nouveau solde : " + solde);
    }
}

