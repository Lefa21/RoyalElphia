package fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;

public class Géant extends Ennemis {

    public Géant(Terrain terrain){
        super(terrain,200,80,2,100,70);
    }

    // Immunité 2 -->  Immunisé face au tour boule de feu

}
