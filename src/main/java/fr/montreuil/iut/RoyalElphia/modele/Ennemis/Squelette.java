package fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;

public class Squelette extends Ennemis {
    public Squelette(Terrain terrain) {
        super(terrain, 50, 20, 4, 30, 20,0,0,1,1);
    }
    // Immunité 4 -->  Immunisé face au tour flèche
}