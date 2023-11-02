package fr.montreuil.iut.RoyalElphia.modele.Tour.StrategieTour;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Tour.Tour;

public interface StrategieTour {

    void attaqueRecharge(Tour T);

    void attaqueEvolutive(Tour T, int nbEnnemis, Terrain Ter);
}
