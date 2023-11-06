package fr.montreuil.iut.RoyalElphia.modele.Tour.StrategieTour;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Tour.Tour;

public class AttaqueRecharge implements StrategieTour {     // Tour qui attaque toutes les 3.5 secondes et inflige un gros dégat.
    private long derniereAttaque = 0;
    private static final long DELAI = 3500;
    @Override
    public void attaqueRecharge(Tour T) {
        long tempsActuel = System.currentTimeMillis();
        // Vérifie si le temps écoulé depuis la dernière Attaque est supérieur ou égal à 3.5 sec
        if (tempsActuel - derniereAttaque >= DELAI) {
            T.setDegat(70);
            // Met à jour le temps de la dernière attaque
            derniereAttaque = tempsActuel;
        } else {
            T.setDegat(0);
        }
    }

    @Override
    public void attaqueEvolutive(Tour T, int nbEnnemis, Terrain Ter) {

    }
}
