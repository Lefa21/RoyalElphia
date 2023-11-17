package fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieDeplacement.DeplacementTeleportation;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieAttaque.*;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle;

public class Squelette extends Ennemis {
    public Squelette(Terrain terrain) {

        super(terrain, 50, 0, 4, 4, 20,0,0, new DeplacementTeleportation(),new StrategieChangeante());


    }
    // Immunité 4 -->  Immunisé face au tour flèche

    public void strategieAttaque(Obstacle o) {
        sa.AttaqueEnnemi(getCapaciteObstacle(),getX(),getY(),o);
    }

    public String getChemin() {
        return "src/main/resources/fr/montreuil/iut/RoyalElphia/ImageEnnemis/squelette.png";
    }
}