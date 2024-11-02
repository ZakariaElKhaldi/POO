package src;

public class Rectangle extends Form {
	private int lang;
	private int larg;

	public Rectangle(int lang, int larg) {
		this.lang = lang;
		this.larg = larg;
	}

	public float surface() {
		return lang * larg;
	}

	public float perimetre() {
		return (float) ((lang + larg) * 2.0);
	}

}
