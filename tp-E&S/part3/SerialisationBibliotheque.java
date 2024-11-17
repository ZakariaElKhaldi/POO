package part3;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerialisationBibliotheque {
    public static void main(String[] args) {
        List<Livre> bibliotheque = creerBibliotheque();
        String fichier = "bibliotheque.ser";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {
            oos.writeObject(bibliotheque);
            System.out.println("Bibliothèque sauvegardée avec succès dans " + fichier);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sérialisation : " + e.getMessage());
        }
    }

    private static List<Livre> creerBibliotheque() {
        List<Livre> bibliotheque = new ArrayList<>();
        bibliotheque.add(new Livre("Le Petit Prince", "Antoine de Saint-Exupéry", 1943));
        bibliotheque.add(new Livre("1984", "George Orwell", 1949));
        bibliotheque.add(new Livre("Dune", "Frank Herbert", 1965));
        return bibliotheque;
    }
}
