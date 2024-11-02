package exfinal;

public class Developpeur extends Employe{
	 public String langage;
	 
	 public Developpeur(String nom, int salaire, String langage) {
		super(nom, salaire);
		this.langage = langage;
	}

	@Override
	 public void afficherInfos() {
		System.out.println("");
		super.afficherInfos();
	    System.out.println("Langage: " + langage);
	 }

	 public void afficherLangage() {
	        System.out.println("\n" + nom + " utilise le langage: " + langage);
	 }
}
