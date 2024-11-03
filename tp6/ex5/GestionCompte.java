package ex5;

public class GestionCompte {
    public static void main(String[] args) {
        Compte compte = new Compte(100.0);  
        try {
            compte.verser(-50.0);  
        } catch (MontantNegatifException e) {
            System.out.println(e.getMessage()); 
        }

        try {
            compte.retirer(-20.0); 
        } catch (MontantNegatifException | SoldeInsuffisantException e) {
            System.out.println(e.getMessage());
        }
    }
}

