package src;

public class Voiture extends Vehicule implements Roulant {
	public Voiture(String nom, String typeCarburant) {
		super(nom, typeCarburant);
	}

	public void demarrer() {
		System.out.println("La voiture démarre.");
	}

	public void arreter() {
		System.out.println("La voiture s'arrête.");
	}

	public void rouler() {
		System.out.println("La voiture roule.");
	}
}
