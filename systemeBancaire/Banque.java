package systemeBancaire;
import java.util.ArrayList;

public class Banque {
    private ArrayList<CompteBancaire> comptes;
    private static int nombreComptes = 0;

    public Banque() {
        this.comptes = new ArrayList<>();
    }

    public void ajouterCompte(CompteBancaire compte) {
        comptes.add(compte);
        nombreComptes++;
    }

    public CompteBancaire chercherCompte(String numeroCompte) {
        for (CompteBancaire compte : comptes) {
            if (compte.getNumeroCompte().equals(numeroCompte)) {
                return compte;
            }
        }
        return null;
    }

    public void transfert(String numeroSource, String numeroDest, double montant) {
        CompteBancaire source = chercherCompte(numeroSource);
        CompteBancaire destination = chercherCompte(numeroDest);
        if (source != null && destination != null && source.getSolde() >= montant) {
            source.retirer(montant);
            destination.deposer(montant);
            System.out.println("Transfert de " + montant + " effectué de " + numeroSource + " vers " + numeroDest);
        } else {
            System.out.println("Transfert refusé.");
        }
    }

    public static void afficherNombreComptes() {
        System.out.println("Nombre total de comptes : " + nombreComptes);
    }
}

