package fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;

public class Sorcières extends Ennemis {

    public Sorcières(Terrain terrain) {
        super(terrain, 150, 70, 1, 40, 80);
        // Immunité 1 -->  Immunisé face au tour à bombe
    }
}
