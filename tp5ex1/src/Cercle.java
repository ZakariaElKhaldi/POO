package src;

public class Cercle extends Form {
	private int ridus;

	public Cercle(int ridus) {
		this.ridus = ridus;
	}

	public float surface() {
		return (float) (ridus * ridus * Math.PI);
	}

	public float perimetre() {
		return (float) (ridus * 2.0 * Math.PI);
	}

}
