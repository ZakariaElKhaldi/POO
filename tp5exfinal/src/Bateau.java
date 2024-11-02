package src;

public class Bateau extends Vehicule implements Flottant {
	public Bateau(String nom, String typeCarburant) {
		super(nom, typeCarburant);
	}

	public void demarrer() {
		System.out.println("Le bateau démarre.");
	}

	public void arreter() {
		System.out.println("Le bateau s'arrête.");
	}

	public void flotter() {
		System.out.println("Le bateau flotte.");
	}
}
