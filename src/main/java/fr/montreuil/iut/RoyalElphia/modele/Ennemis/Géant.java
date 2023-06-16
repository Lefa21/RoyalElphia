package fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;

public class Géant extends Ennemis {

    public Géant(Terrain terrain){
        super(terrain,150,85,2,1,60,3,15);
    }

    // Immunité 2 -->  Immunisé face au tour boule de feu

}
