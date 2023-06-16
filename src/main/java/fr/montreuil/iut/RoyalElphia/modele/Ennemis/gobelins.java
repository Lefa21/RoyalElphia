package fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;

public class gobelins extends Ennemis {

    public gobelins(Terrain terrain) {
        super(terrain, 75, 20, 3, 3, 35,1,5);
    }

    // Immunité 3 -->  Immunisé face au tour électrique


}
