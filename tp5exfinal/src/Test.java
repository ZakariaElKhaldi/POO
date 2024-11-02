package src;

public class Test {
	public static void main(String[] args) {
		Vehicule[] vehicules = {
				new Voiture("Voiture", "Essence"),
				new Bateau("Bateau", "Diesel"),
				new Hydravion("Hydravion", "Kérosène")
		};

		for (Vehicule v : vehicules) {
			v.afficherInfos();
			v.demarrer();
			v.arreter();

			if (v instanceof Roulant) {
				((Roulant) v).rouler();
			}
			if (v instanceof Flottant) {
				((Flottant) v).flotter();
			}
			if (v instanceof Volant) {
				((Volant) v).voler();
			}
		}
	}
}
