package src;

public class Test {
	public static void main(String[] args) {
		Cercle cercle = new Cercle(5);
		System.out.println("la sufface du cercle est : " + cercle.surface() + "\n" +
				"la perimetre du cercle est : " + cercle.perimetre());

		Rectangle rectangle = new Rectangle(10, 20);
		System.out.println("la sufface du rectangle est : " + rectangle.surface() + "\n" +
				"la perimetre du rectangle est : " + rectangle.perimetre());

		Triangle triangle = new Triangle(3, 4, 3, 4, 5);
		System.out.println("la sufface du triangle est : " + triangle.surface() + "\n" +
				"la perimetre du triangle est : " + triangle.perimetre());

	}

}
