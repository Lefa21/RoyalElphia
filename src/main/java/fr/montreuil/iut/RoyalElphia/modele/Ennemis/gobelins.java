package fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;

public class gobelins extends Ennemis {

    public gobelins(Terrain terrain) {
        super(terrain, 100, 30, 3, 40, 50,2,1,1,1);
    }

    // Immunité 3 -->  Immunisé face au tour électrique


}
