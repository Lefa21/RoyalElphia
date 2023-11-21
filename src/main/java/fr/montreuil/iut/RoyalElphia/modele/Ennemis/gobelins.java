package fr.montreuil.iut.RoyalElphia.modele.Ennemis;


import fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieAttaque.AttaqueEnFonctionDeLaBase;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieDeplacement.DeplacementSimple;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle;

public class gobelins extends Ennemis {


    public gobelins(Terrain terrain) {
        super(terrain, 75, 20, 3, 3, 35,1,5, new DeplacementSimple(),new AttaqueEnFonctionDeLaBase());

    }
    // Immunité 3 -->  Immunisé face au tour électrique
    @Override
    public void strategieAttaque(Obstacle o) {
        sa.AttaqueEnnemi(getX(),getY(),o);
    }

    public String getChemin() {
        return "src/main/resources/fr/montreuil/iut/RoyalElphia/ImageEnnemis/gobelin.png";
    }



}
