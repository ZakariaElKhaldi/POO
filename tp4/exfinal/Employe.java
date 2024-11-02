package exfinal;

public class Employe {
	public String nom;
	public int salaire;
	
	public Employe(String nom, int salaire) {
		this.nom = nom;
		this.salaire = salaire;
	}

	public void afficherInfos() {
		System.out.println("");
		System.out.println(
			"nom : " + nom + 
			"\n salaire : " + salaire
		); 
	}
	
}
