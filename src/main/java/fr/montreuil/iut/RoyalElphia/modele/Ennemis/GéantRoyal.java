package fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;

public class GéantRoyal extends Ennemis {

    public GéantRoyal(Terrain terrain) {
        super(terrain, 200, 80, 5, 1, 150,4,20);
    }
    // Immunité 5 -->  Immunisé face au tour laser
}
