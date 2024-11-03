package ex6;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionCompte {
    public static void main(String[] args) {
        Compte compte = new Compte(500.0);  // Initial balance set to 500
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Entrez un montant à retirer : ");
            double montant = scanner.nextDouble();
            compte.retirer(montant);
        } catch (InputMismatchException e) {
            System.out.println("Erreur : Vous devez entrer un nombre valide.");
        } catch (MontantNegatifException e) {
            System.out.println(e.getMessage());
        } catch (SoldeInsuffisantException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Opération terminée.");
            scanner.close();
        }
    }
}
