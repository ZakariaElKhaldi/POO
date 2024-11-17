package part2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EcritureTexte {
    public static void main(String[] args) {
        String fichierSource = "livres.txt";
        String fichierDestination = "sortie.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fichierSource));
             BufferedWriter bw = new BufferedWriter(new FileWriter(fichierDestination))) {

            String ligne;
            // Transfer lines from the source to the destination file
            while ((ligne = br.readLine()) != null) {
                bw.write(ligne);
                bw.newLine();
            }
            System.out.println("La liste des livres a été écrite dans " + fichierDestination);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
        }
    }
}

