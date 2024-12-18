package tpcolection;

public class ClientFidel extends Client {
    private String codeFidelite;
    private float tauxReduction;

    public ClientFidel(String code, String nom, String adresse, String telephone, 
                       String codeFidelite, float tauxReduction) {
        super(code, nom, adresse, telephone);
        this.codeFidelite = codeFidelite;
        this.tauxReduction = tauxReduction;
    }

    @Override
    public String toString() {
        return super.toString() + 
               "\nCode Fidélité: " + codeFidelite + 
               "\nTaux de Réduction: " + tauxReduction + "%";
    }
}
