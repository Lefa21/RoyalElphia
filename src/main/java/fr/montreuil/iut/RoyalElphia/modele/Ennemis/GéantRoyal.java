package fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import fr.montreuil.iut.RoyalElphia.modele.Capacite.Capacite;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;

public class GéantRoyal extends Ennemis {

    public GéantRoyal(Terrain terrain) {
        super(terrain, 200, 100, 5, 1, 80,4,20);
    }
    // Immunité 5 -->  Immunisé face au tour laser
}
