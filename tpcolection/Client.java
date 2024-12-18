package tpcolection;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private String codeClient;
    private String nomClient; 
    private String adrClient;
    private String telClient;
    private List<Commande> listCommandes;

    public Client(String codeClient, String nomClient, String adrClient, String telClient) {
        this.codeClient = codeClient;
        this.nomClient = nomClient;
        this.adrClient = adrClient;
        this.telClient = telClient;
        this.listCommandes = new ArrayList<>();
    }

    public boolean enregistrerCommande(Commande cmd) {
        return listCommandes.add(cmd);
    }

    public boolean supprimerCommande(int numCommande) {
        for (int i = 0; i < listCommandes.size(); i++) {
            Commande commande = listCommandes.get(i);
            if (commande.getNumCommande() == numCommande) {
                listCommandes.remove(i);
                return true;
            }
        }
        return false;
    }

    public String getCodeClient() {
        return codeClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public String getAdrClient() {
        return adrClient;
    }

    public String getTelClient() {
        return telClient;
    }

    public List<Commande> getListCommandes() {
        return new ArrayList<>(listCommandes);
    }

    @Override
    public String toString() {
        String result = "Client: " + nomClient + 
                       "\nCode: " + codeClient + 
                       "\nAdresse: " + adrClient + 
                       "\nTéléphone: " + telClient;
        
        if(listCommandes.isEmpty()) {
            result += "\nAucune commande";
        } else {
            result += "\nCommandes:";
            for(Commande c : listCommandes) {
                result += "\n- " + c.toString();
            }
        }
        return result;
    }
}
