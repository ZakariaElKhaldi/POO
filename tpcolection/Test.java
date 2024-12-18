package tpcolection;

import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        try {
            // Créer des commandes
            Commande cmd1 = new Commande(1, new Date(), "Carrefour");
            Commande cmd2 = new Commande(2, new Date(), "Auchan"); 
            Commande cmd3 = new Commande(3, new Date(), "Leclerc");
            Commande cmd4 = new Commande(4, new Date(), "Carrefour"); // Pour tester les doublons

            // Créer des clients
            Client client1 = new Client("C1", "Jean Dupont", "Paris", "0123456789");
            ClientFidel client2 = new ClientFidel("C2", "Marie Martin", "Lyon", 
                                                  "0987654321", "FID001", 10.0f);

            // Ajouter des commandes aux clients
            client1.enregistrerCommande(cmd1);
            client1.enregistrerCommande(cmd2);
            client2.enregistrerCommande(cmd3);
            client2.enregistrerCommande(cmd4);

            // Utiliser un Set pour éviter les doublons de commandes
            Set<Commande> commandesUniques = new HashSet<>();
            commandesUniques.add(cmd1);
            commandesUniques.add(cmd2);
            commandesUniques.add(cmd3);
            commandesUniques.add(cmd4);

            // Trier les commandes d'un client
            List<Commande> commandesClient1 = new ArrayList<>(client1.getListCommandes());
            Collections.sort(commandesClient1); // Utilise compareTo de Commande

            // Utiliser une List pour les clients
            List<Client> listeClients = new ArrayList<>();
            listeClients.add(client1);
            listeClients.add(client2);

            // Utiliser une Map pour associer codeClient -> Client
            Map<String, Client> mapClients = new HashMap<>();
            for (Client c : listeClients) {
                mapClients.put(c.getCodeClient(), c);
            }

            // Écrire dans un fichier
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("clients.txt"))) {
                for (Client client : listeClients) {
                    writer.write(client.toString());
                    writer.newLine();
                    writer.newLine(); // Ajouter une ligne vide entre les clients
                }
            }

            // Lire depuis le fichier
            System.out.println("Lecture du fichier clients.txt:");
            try (BufferedReader reader = new BufferedReader(new FileReader("clients.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

            // Add verification output
            System.out.println("\nCommandes uniques:");
            for(Commande cmd : commandesUniques) {
                System.out.println(cmd);
            }

            System.out.println("\nCommandes triées du client 1:");
            for(Commande cmd : commandesClient1) {
                System.out.println(cmd);
            }

        } catch (IOException e) {
            System.err.println("Erreur lors de la manipulation du fichier: " + e.getMessage());
        }
    }
}
