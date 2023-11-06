package fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieDeplacement.DeplacementSimple;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieDeplacement.StrategieDeplacement;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;

public class Sorcières extends Ennemis {

    public Sorcières(Terrain terrain) {
        super(terrain, 100, 35, 1, 2, 55,2,10, new DeplacementSimple());
        // Immunité 1 -->  Immunisé face au tour à bombe
    }
}
