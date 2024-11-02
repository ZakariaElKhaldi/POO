package src;

class Triangle extends Form {
	private double base;
	private double hauteur;
	private double coteA;
	private double coteB;
	private double coteC;

	public Triangle(double base, double hauteur, double coteA, double coteB, double coteC) {
		this.base = base;
		this.hauteur = hauteur;
		this.coteA = coteA;
		this.coteB = coteB;
		this.coteC = coteC;
	}

	public float surface() {
		return (float) ((base * hauteur) / 2);
	}

	public float perimetre() {
		return (float) (coteA + coteB + coteC);
	}
}
