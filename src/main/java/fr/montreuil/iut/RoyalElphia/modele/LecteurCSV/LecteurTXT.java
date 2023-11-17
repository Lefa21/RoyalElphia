package fr.montreuil.iut.RoyalElphia.modele.LecteurCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LecteurTXT {

    public static int[][] lireMatriceDepuisFichier(String cheminFichier) {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(cheminFichier));
            String ligne;
            int ligneIndex = 0;

            int nombreLignes = 0;
            int nombreColonnes = 0;

            while ((ligne = br.readLine()) != null) {
                nombreLignes++;
                String[] valeurs = ligne.trim().split("\\s+");
                nombreColonnes = Math.max(nombreColonnes, valeurs.length);
            }

            int[][] matrice = new int[nombreLignes][nombreColonnes];

            br.close();
            br = new BufferedReader(new FileReader(cheminFichier));

            while ((ligne = br.readLine()) != null) {
                String[] valeurs = ligne.trim().split("\\s+");
                for (int j = 0; j < valeurs.length; j++) {
                    matrice[ligneIndex][j] = Integer.parseInt(valeurs[j]);
                }
                ligneIndex++;
            }

            return matrice;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
/*
    public static void main(String[] args) {
        String cheminFichier = "C:\\Users\\alaae\\IdeaProjects\\RoyalElphiaLECTEUR\\tab1.txt";

        int[][] matrice = lireMatriceDepuisFichier(cheminFichier);

        if (matrice != null) {
            for (int i = 0; i < matrice.length; i++) {
                for (int j = 0; j < matrice[i].length; j++) {
                    System.out.print(matrice[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
*/
}
