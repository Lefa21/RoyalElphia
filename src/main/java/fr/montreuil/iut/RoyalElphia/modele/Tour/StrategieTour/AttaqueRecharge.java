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

