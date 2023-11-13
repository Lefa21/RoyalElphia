package fr.montreuil.iut.RoyalElphia.modele.LecteurCSV;

import java.io.*;
import java.util.ArrayList;

public class LecteurCSV {
    private String cheminFichier = "score.csv";
    public LecteurCSV(){
    }

    public void ecritureFichier(String[] tableau) {
        try {
            ArrayList<String> lignesExistantes = new ArrayList<>();

            // Lecture du fichier existant
            try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {
                String ligne;
                while ((ligne = reader.readLine()) != null) {
                    lignesExistantes.add(ligne);
                }
            }

            // Ajout de la nouvelle ligne au début de la liste
            String nouvelleLigne = String.join(";", tableau);
            lignesExistantes.add(0, nouvelleLigne);

            // Écriture des lignes dans le fichier
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier))) {
                for (String ligne : lignesExistantes) {
                    writer.write(ligne);
                    writer.newLine();
                }
            }

            System.out.println("Écriture dans le fichier CSV terminée avec succès.");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier CSV : " + e.getMessage());
        }
    }

    public String lecteurFichier() {
        StringBuilder contenuFichier = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] rowData = ligne.split(";");
                String rowDataWithTabs = String.join("\t\t", rowData);
                contenuFichier.append(rowDataWithTabs).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contenuFichier.toString();
    }
}
