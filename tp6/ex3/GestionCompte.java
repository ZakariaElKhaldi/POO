package ex3;

public class GestionCompte {
    public static void main(String[] args) {
        Compte compte = new Compte(100.0);

        try {
            System.out.println("Solde actuel : " + compte.getSolde());
            compte.retirer(150.0);
        } catch (SoldeInsuffisantException e) {
            System.out.println(e.getMessage()); 
        }
    }
}
