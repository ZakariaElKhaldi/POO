package part3;
import java.io.Serializable;

public class Livre implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titre;
    private String auteur;
    private int anneePublication;

    public Livre(String titre, String auteur, int anneePublication) {
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
    }

    // Getters
    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getAnneePublication() {
        return anneePublication;
    }

    @Override
    public String toString() {
        return "Livre{" +
               "titre='" + titre + '\'' +
               ", auteur='" + auteur + '\'' +
               ", anneePublication=" + anneePublication +
               '}';
    }
}


