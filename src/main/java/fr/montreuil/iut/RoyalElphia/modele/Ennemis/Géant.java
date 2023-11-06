package fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieDeplacement.DeplacementSimple;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieDeplacement.StrategieDeplacement;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;

public class Géant extends Ennemis {

    public Géant(Terrain terrain){
        super(terrain,150,65,2,1,100,3,15, new DeplacementSimple());
    }

    // Immunité 2 -->  Immunisé face au tour boule de feu

}
