package part1;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopierFichierBinaire {
    public static void main(String[] args) {
        String fichierSource = "source.bin";  
        String fichierDestination = "destination.bin"; 

        try (FileInputStream fis = new FileInputStream(fichierSource);
             FileOutputStream fos = new FileOutputStream(fichierDestination)) {

            int octet;
            // Transfer each byte from source to destination
            while ((octet = fis.read()) != -1) {
                fos.write(octet);
            }
            System.out.println("Le fichier a été copié avec succès.");
        } catch (IOException e) {
            System.err.println("Erreur lors de la copie du fichier : " + e.getMessage());
        }
    }
}
