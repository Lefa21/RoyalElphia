package fr.montreuil.iut.RoyalElphia.modele.Ennemis;


import fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieDeplacement.DeplacementSimple;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieAttaque.AttaqueCorpsAcorps;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle;

public class Géant extends Ennemis {

    public Géant(Terrain terrain){

        super(terrain,150,65,2,1,100,3,15, new DeplacementSimple(), new AttaqueCorpsAcorps());

    }

    // Immunité 2 -->  Immunisé face au tour boule de feu
    public void strategieAttaque(Obstacle o) {
        sa.AttaqueEnnemi(getCapaciteObstacle(),getX(),getY(),o);
    }

    public String getChemin() {
        return "src/main/resources/fr/montreuil/iut/RoyalElphia/ImageEnnemis/Geant.png";
    }
}
