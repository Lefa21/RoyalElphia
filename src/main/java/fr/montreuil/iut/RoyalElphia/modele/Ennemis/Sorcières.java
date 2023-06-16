package fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;

public class Sorcières extends Ennemis {

    public Sorcières(Terrain terrain) {
        super(terrain, 100, 35, 1, 2, 55,2,10);
        // Immunité 1 -->  Immunisé face au tour à bombe
    }
}
