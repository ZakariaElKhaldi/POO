package src;

public class Hydravion extends Vehicule implements Flottant, Volant {
	public Hydravion(String nom, String typeCarburant) {
		super(nom, typeCarburant);
	}

	public void demarrer() {
		System.out.println("L'hydravion démarre.");
	}

	public void arreter() {
		System.out.println("L'hydravion s'arrête.");
	}

	public void flotter() {
		System.out.println("L'hydravion flotte.");
	}

	public void voler() {
		System.out.println("L'hydravion vole.");
	}
}
