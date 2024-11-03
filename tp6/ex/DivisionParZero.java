package ex;
public class DivisionParZero {
    public static void main(String[] args) {
        int numerator = 10; 
        int denominator = 1;

        try {
            int result = numerator / denominator;
            System.out.println("Résultat : " + result);
        } catch (ArithmeticException e) {
            System.out.println("Erreur : Division par zéro !");
        } finally {
            System.out.println("Bloc finally exécuté. Le programme s’est terminé.");
        }
    }
}

