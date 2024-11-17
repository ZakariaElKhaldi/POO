package part3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class DeserialisationBibliotheque {
    public static void main(String[] args) {
        String fichier = "bibliotheque.ser"; // Fichier binaire

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
            // Désérialiser la liste de livres
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                List<Livre> bibliotheque = (List<Livre>) obj;
                afficherBibliotheque(bibliotheque);
            } else {
                System.err.println("Le fichier ne contient pas une liste de livres valide.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erreur lors de la désérialisation : " + e.getMessage());
        }
    }

    private static void afficherBibliotheque(List<Livre> bibliotheque) {
        System.out.println("Bibliothèque désérialisée :");
        for (Livre livre : bibliotheque) {
            System.out.println(livre);
        }
    }
}

