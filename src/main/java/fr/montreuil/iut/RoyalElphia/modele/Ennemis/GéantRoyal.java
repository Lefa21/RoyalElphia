package fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;

public class GéantRoyal extends Ennemis {

    public GéantRoyal(Terrain terrain) {
        super(terrain, 300, 200, 5, 40, 120);
    }
    // Immunité 5 -->  Immunisé face au tour laser
}
