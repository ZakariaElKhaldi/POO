package tpcolection;
import java.util.Date;

public class Commande implements Comparable<Commande> {
    private int numCommande;
    private Date dateCommande; 
    private String nomFournisseur;

    public Commande(int numCommande, Date dateCommande, String nomFournisseur) {
        this.numCommande = numCommande;
        this.dateCommande = dateCommande;
        this.nomFournisseur = nomFournisseur;
    }

    public int getNumCommande() {
        return numCommande;
    }

    public void setNumCommande(int numCommande) {
        this.numCommande = numCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    @Override
    public String toString() {
        return "Commande numéro: " + numCommande + 
               ", Date: " + dateCommande + 
               ", Fournisseur: " + nomFournisseur;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Commande other = (Commande) obj;
        return numCommande == other.numCommande;
    }

    @Override
    public int compareTo(Commande other) {
        return this.dateCommande.compareTo(other.dateCommande);
    }
}
