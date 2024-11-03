package ex;
import java.util.Scanner;

public class ConversionNombre {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Veuillez saisir un nombre : ");
			String input = scanner.nextLine();

			convertirEnEntier(input);
		}
    }

    public static void convertirEnEntier(String nombre) {
      
    	try {
            int resultat = Integer.parseInt(nombre);
            System.out.println("Le nombre saisi est : " + resultat);
        } catch (NumberFormatException e) {
            System.out.println("Erreur : La saisie '" + nombre + "' n'est pas un nombre valide.");
        } finally {
            System.out.println("Bloc finally : Conversion terminée.");
        }
    	
    }
    
}
