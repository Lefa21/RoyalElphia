/*package fr.montreuil.iut.RoyalElphia.modele.Tour.StrategieTour;

import fr.montreuil.iut.RoyalElphia.modele.Tour.Tour;

public class AttaqueRecharge implements StrategieTour {     // Tour qui attaque toutes les 1.5 secondes et inflige un gros dégat.
    private long derniereAttaque = 0;
    private static final long DELAI = 1500;
    @Override
    public void attaque(Tour T) {
        long tempsActuel = System.currentTimeMillis();
        // Vérifie si le temps écoulé depuis la dernière Attaque est supérieur ou égal à 1.5 sec
        if (tempsActuel - derniereAttaque >= DELAI) {
            T.setDegat(70);
            // Met à jour le temps de la dernière attaque
            derniereAttaque = tempsActuel;
        } else {
            T.setDegat(0);
        }
    }
}*/
package fr.montreuil.iut.RoyalElphia.modele.Tour.StrategieTour;

import fr.montreuil.iut.RoyalElphia.modele.Tour.Tour;

public class AttaqueRecharge implements StrategieTour {
    private long derniereAttaque = 0;
    private static final long DELAI = 1000;
    private int degat;
    private boolean initialisation = true;

    @Override
    public void attaque(Tour T) {
        if (initialisation ){this.degat = T.getDegat();initialisation= false;}
        long tempsActuel = System.currentTimeMillis();

        double tempsEcoule = (tempsActuel - derniereAttaque) / 1000.0;
         degat = degat + 1;
         if (degat >=85) this.degat = 3;
        if (tempsEcoule >= DELAI / 1000.0) {
            T.setDegat(degat);
            derniereAttaque = tempsActuel;
        } else {
            T.setDegat(0);
        }
    }
}

