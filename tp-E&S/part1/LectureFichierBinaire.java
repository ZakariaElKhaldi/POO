package part1;
import java.io.FileInputStream;
import java.io.IOException;

public class LectureFichierBinaire {
    public static void main(String[] args) {
        String cheminFichier = "fichier.bin";

        try (FileInputStream fis = new FileInputStream(cheminFichier)) {
            int octet;
            // Read and display the file byte by byte
            while ((octet = fis.read()) != -1) {
                System.out.print(octet + " ");
            }
        } catch (IOException e) {
    
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
}

