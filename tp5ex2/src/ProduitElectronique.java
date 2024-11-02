package src;

public class ProduitElectronique implements Produit {
	private String nom;
	private int quantite;
	private float prixUnitaire;

	public ProduitElectronique(String nom, int quantite, float prixUnitaire) {
		this.nom = nom;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
	}

	public float calculerValeurStock() {
		return quantite * prixUnitaire;
	}
}
