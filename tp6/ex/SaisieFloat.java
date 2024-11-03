package ex;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SaisieFloat {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Entrez un nombre : ");

			try {
			    float nombre = scanner.nextFloat();
			    System.out.println("Vous avez entré le nombre : " + nombre);
			} catch (InputMismatchException e) {
			    System.out.println("Erreur : Vous devez entrer un nombre valide.");
			}
		}
    }
}

