package exfinal;

public class Main {
    public static void main(String[] args) {
 
        Employe[] employes = {
            new Developpeur("zakaria", 1, "c++"),
            new Manager("zakaria2", 2, 5),
            new Developpeur("zakaria3", 3, "rust"),
            new Manager("zakaria4", 4, 10)
        };

        for (Employe employe : employes) {
            employe.afficherInfos();
        }

        // Sur-casting (upcasting)
        Employe employeDev = new Developpeur("zakaria5", 5, "go");
        employeDev.afficherInfos();
        // employeDev.afficherLangage(); will not work
        
        // Sous-casting (downcasting) avec instanceof
        for (Employe employe : employes) {
            if (employe instanceof Developpeur) {
                Developpeur dev = (Developpeur) employe;
                dev.afficherLangage();
            } else if (employe instanceof Manager) {
                Manager mgr = (Manager) employe;
                mgr.gererEquipe();
            }
        }
    }
}
