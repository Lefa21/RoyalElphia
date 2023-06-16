package fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;

public class gobelins extends Ennemis {

    public gobelins(Terrain terrain) {
        super(terrain, 75, 35, 3, 3, 20,1,5);
    }

    // Immunité 3 -->  Immunisé face au tour électrique


}
