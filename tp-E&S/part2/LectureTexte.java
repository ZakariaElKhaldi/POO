package part2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectureTexte {
    public static void main(String[] args) {
        String fichierTexte = "livres.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fichierTexte))) {
            String ligne;
            // Read and print each line of the text file
            while ((ligne = br.readLine()) != null) {
                System.out.println(ligne);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
}
